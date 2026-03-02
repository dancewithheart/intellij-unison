import org.jetbrains.sbtidea.Keys.*
import sbt.{CompileOrder, *}
import Keys.{compileOrder, *}

ThisBuild / scalaVersion := "2.13.18"

ThisBuild / intellijPluginName := "intellij-unison"
ThisBuild / intellijBuild := "251.26927.53" // 253.31033.145
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity

val junitInterfaceVersion = "0.13.3"
val opentest4jVersion = "1.3.0"
val junitVersion = "4.13.2"

lazy val genRoot = settingKey[File]("Root directory for generated sources")

lazy val unison =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.3",
      Compile / javacOptions ++= Seq("--release", "17"),
      Compile / scalacOptions ++= Seq("--release", "17"),
      compileOrder := CompileOrder.Mixed,
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies ++= Seq(
        "com.github.sbt" % "junit-interface" % junitInterfaceVersion % Test,
        "org.opentest4j" % "opentest4j" % opentest4jVersion % Test,
        "org.jetbrains" % "grammar-kit" % "2023.3" % Provided,
        "junit" % "junit" % junitVersion % Test,
        "dev.zio" %% "zio-test"     % "2.0.21" % Test,
        "dev.zio" %% "zio-test-sbt" % "2.0.21" % Test
      ),
      genRoot := (Compile / sourceManaged).value / "unison-gen",
      Compile / managedSourceDirectories += genRoot.value,
    )

lazy val benchmarks = project
  .in(file("benchmarks"))
  .dependsOn(unison)
  .enablePlugins(SbtIdeaPlugin, JmhPlugin)
  .settings(
    publish / skip := true,
    fork := true,
    scalacOptions -= "-Yno-imports",
    scalacOptions -= "-Xfatal-warnings",
    scalaVersion := (ThisBuild / scalaVersion).value,

    // add IntelliJ SDK + plugin jars to the JMH runtime classpath ----
    // We reuse the classpath that sbt-idea-plugin already assembled for `unison` tests.
    // That classpath includes the IntelliJ SDK jars under ~/.intellij-.../sdk/.../lib/*.jar
    Compile / fullClasspath ++= (unison / Test / fullClasspath).value,
    Compile / fullClasspath ++= (unison / Compile / fullClasspath).value,

    Jmh / fullClasspath ++= (unison / Test / fullClasspath).value,
    Jmh / fullClasspath ++= (unison / Compile / fullClasspath).value,


    // Do NOT inherit Test/javaOptions with desktop/com.apple opens.
    // For lexer-only benchmarks, headless is enough.
    Jmh / javaOptions := Seq(
      "-Djava.awt.headless=true"
    )
  )

addCommandAlias("b", "benchmarks/jmh:run .*lexWholeFile.*")

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
  val baseDir  = baseDirectory.value
  val srcDir   = baseDir / "src" / "main" / "jflex"
  val flexFile = srcDir / "Unison.flex"
  val outDir   = genRoot.value  // output dir must be the *package root*

  streams.value.log.info(s"Generate lexer from $flexFile into $outDir")

  // fail fast on missing input
  if (!flexFile.exists()) {
    sys.error(s"Lexer generation failed: input .flex file not found: $flexFile")
  }
  IO.createDirectory(outDir)

  streams.value.log.info(s"JFlex: $flexFile -> $outDir")
  jflexRun(Array("-d", outDir.getAbsolutePath, flexFile.getAbsolutePath))

  // return generated files so sbt tracks them
  (outDir ** "*.java").get
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
  val sdkLibDir = {
    val candidates = (sdkRoot * "*").get
      .filter(_.isDirectory)
      .map(_ / "lib")
      .filter(_.isDirectory)
    // prefer the one that contains idea.jar
    val withIdeaJar = candidates.filter(d => (d / "idea.jar").exists())
    val pickFrom = if (withIdeaJar.nonEmpty) withIdeaJar else candidates
    pickFrom.sortBy(_.lastModified()).lastOption.getOrElse {
      sys.error(s"Could not find IntelliJ SDK lib dir under $sdkRoot/*/lib (with idea.jar). Run `sbt runIDE` once.")
    }
  }

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

  val exit = Fork.java(forkOpts, javaArgs)
  if (exit != 0) sys.error(s"Grammar-Kit failed with exit code $exit")

  (outRoot ** "*.java").get
}

Compile / sourceGenerators += generateParser.taskValue

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
Test / fork := true
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
addCommandAlias("t", "clean;compile;test")
addCommandAlias("r", "runIDE")
addCommandAlias("f", "scalafmtAll")
