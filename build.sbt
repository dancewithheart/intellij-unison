import org.jetbrains.sbtidea.Keys.*
import sbt._
import Keys._

// IntelliJ 2026.1 (261)	uses JDK 21
// 261 for compatibility with older IDEs
// "262.10968.176"
val intellijVersion = "261.27258.82"

ThisBuild / scalaVersion := "2.13.18"

ThisBuild / intellijPluginName := "intellij-unison"

ThisBuild / intellijBuild := intellijVersion
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity
ThisBuild / resolvers += "IntelliJ Releases" at "https://www.jetbrains.com/intellij-repository/releases/"
ThisBuild / resolvers += "IntelliJ Dependencies" at "https://packages.jetbrains.team/maven/p/ij/intellij-dependencies/"

val zioVersion = "2.1.27"

lazy val genRoot = settingKey[File]("Root directory for generated sources")

lazy val unison =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.3",
      Compile / javacOptions ++= Seq("--release", "21"),
      Compile / scalacOptions ++= Seq("--release", "21"),
      compileOrder := CompileOrder.Mixed,
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies ++= Seq(
        "com.github.sbt" % "junit-interface" % "0.13.3" % Test,
        "org.opentest4j" % "opentest4j" % "1.3.0" % Test,
        "org.jetbrains" % "grammar-kit" % "2023.3.4" % Provided,
        "junit" % "junit" % "4.13.2" % Test,
        "dev.zio" %% "zio-test"     % zioVersion % Test,
        "dev.zio" %% "zio-test-sbt" % zioVersion % Test,
        "com.jetbrains.intellij.platform" % "test-framework" % intellijVersion % Test
      ),
      genRoot := (Compile / sourceManaged).value / "unison-gen",
      Compile / managedSourceDirectories += genRoot.value,
    )

autoRemoveOldCachedIntelliJSDK := true
autoRemoveOldCachedDownloads := true
Global / excludeLintKeys ++= Set(
  autoRemoveOldCachedIntelliJSDK,
  autoRemoveOldCachedDownloads
)

Compile / resourceGenerators += Def.task {
  val in  = baseDirectory.value / "resources" / "META-INF" / "plugin.xml"
  val outDir = baseDirectory.value / "resources" / "META-INF"
  val out = outDir / "plugin.xml"
  IO.createDirectory(outDir)

  val ijBuild = intellijBuild.value              // e.g. "251.26927.53"
  val baseline = ijBuild.takeWhile(_.isDigit)     // "251"
  val since = s"$baseline.0"                      // "251.0"

  val content = IO.read(in)
    .replace("${pluginVersion}", version.value)
    .replace("${sinceBuild}", since)
  IO.write(out, content)

  Seq(out)
}.taskValue

// https://github.com/dlwh/sbt-jflex uses old version of JFlex
// manually one can download JFlex modified by IntelliJ and run
// java -Xmx512m -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 \
// -Dsun.stderr.encoding=UTF-8 -jar ./gen/jflex-1.9.2.jar \
// -d ./gen/intellij/unison ./src/main/scala/intellij/unison/language/Unison.flex
lazy val generateLexer = taskKey[Seq[File]]("Generate Unison lexer (JFlex)")

generateLexer := {
  import jflex.Main.{main => jflexRun}

  val flexFile = baseDirectory.value / "src/main/jflex/Unison.flex"
  val outDir = genRoot.value

  val cached = FileFunction.cached(
    streams.value.cacheDirectory / "unison-lexer",
    FilesInfo.hash,
    FilesInfo.exists
  ) { (_: Set[File]) =>
    IO.createDirectory(outDir)

    jflexRun(Array(
      "-d",
      outDir.getAbsolutePath,
      flexFile.getAbsolutePath
    ))

    Set(outDir / "UnisonLexer.java")
  }

  cached(Set(flexFile)).toSeq
}

Compile / sourceGenerators += generateLexer.taskValue

lazy val generateParser = taskKey[Seq[File]]("Generate Unison parser (Grammar-Kit)")

generateParser := {
  val log = streams.value.log
  val baseDir = baseDirectory.value
  val bnfFile = baseDir / "src" / "main" / "jflex" / "Unison.bnf"
  val outRoot = genRoot.value

  if (!bnfFile.exists()) sys.error(s"Missing: $bnfFile")
  IO.createDirectory(outRoot)

  // locate SDK jars as you already do (kept mostly intact)
  val home = file(sys.props("user.home"))
  val sdkRoot = home / ".intellij-unisonPluginIC" / "sdk"

  // SDK dirs are typically like: ~/.intellij-unisonPluginIC/sdk/251.26927.53/
  val sdkLibDir = sdkRoot / intellijBuild.value / "lib"

  if (!sdkLibDir.isDirectory)
    sys.error(s"IntelliJ SDK not found: $sdkLibDir")

  val sdkJars: Seq[File] = (sdkLibDir * "*.jar").get

  val compileCp = (Compile / dependencyClasspath).value.map(_.data)
  val grammarKitJars = compileCp.filter(_.getName.contains("grammar-kit"))
  if (grammarKitJars.isEmpty) sys.error("No grammar-kit jar found on Compile / dependencyClasspath.")

  val cp = (grammarKitJars ++ sdkJars).distinct
  val cpString = cp.map(_.getAbsolutePath).mkString(java.io.File.pathSeparator)

  val forkOpts = ForkOptions()
    .withWorkingDirectory(baseDir)
    .withOutputStrategy(Some(StdoutOutput))
    .withRunJVMOptions(Vector(
      "-Xmx1g",
      "-Didea.is.unit.test=true",
      "-Djava.awt.headless=true"
    ))

  val javaArgs: Seq[String] =
    Seq("-cp", cpString, "org.intellij.grammar.Main", outRoot.getAbsolutePath, bnfFile.getAbsolutePath)

  log.info(s"Grammar-Kit: $bnfFile -> $outRoot")
  log.info(s"Using IntelliJ SDK lib: ${sdkLibDir.getAbsolutePath}")

  val cached = FileFunction.cached(
    streams.value.cacheDirectory / s"unison-parser-${intellijBuild.value}",
    FilesInfo.hash,
    FilesInfo.exists
  ) { (_: Set[File]) =>

    val exit = Fork.java(forkOpts, javaArgs)

    if (exit != 0)
      sys.error(s"Grammar-Kit failed with exit code $exit")

    val generated = (outRoot ** "*.java").get
      .filterNot(_.getName == "UnisonLexer.java")
      .toSet

    if (generated.isEmpty)
      sys.error(s"No parser files found under $outRoot")

    generated
  }

  cached(Set(bnfFile) ++ grammarKitJars.toSet).toSeq
}

Compile / sourceGenerators += generateParser.taskValue

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
Test / fork := true
Test / javaOptions +=
  s"-Didea.home.path=${(ThisBuild / intellijBaseDirectory).value.getAbsolutePath}"

//Test / javaOptions ++= Seq(
//  "--add-opens=java.base/java.lang=ALL-UNNAMED",
//  "--add-opens=java.base/java.util=ALL-UNNAMED",
//  "--add-opens=java.base/java.io=ALL-UNNAMED",
//  "--add-opens=java.base/java.nio=ALL-UNNAMED",
//  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
//  "--add-opens=java.base/jdk.internal.misc=ALL-UNNAMED",
//  "--add-opens=java.desktop/javax.swing=ALL-UNNAMED",
//  "--add-opens=java.desktop/java.awt=ALL-UNNAMED"
//)

addCommandAlias("c", "clean;compile;")
//addCommandAlias("t", "clean;compile;test")
addCommandAlias("t", "test")
addCommandAlias("r", "runIDE")
addCommandAlias("f", "scalafmtAll")

Test / testOptions += Tests.Filter { testName =>
  val reporting =
    sys.props.get("unison.reports").contains("true")

  val isReport =
    testName == "intellij.unison.PsiReportTest"

  if (reporting) isReport
  else !isReport
}
