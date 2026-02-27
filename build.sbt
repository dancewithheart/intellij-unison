import org.jetbrains.sbtidea.Keys.*
import sbt._
import Keys._

ThisBuild / scalaVersion := "2.13.18"

ThisBuild / intellijPluginName := "intellij-unison"
ThisBuild / intellijBuild := "251.26927.53" // 253.31033.145
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity

val junitInterfaceVersion = "0.13.3"
val opentest4jVersion = "1.3.0"
val junitVersion = "4.13.2"

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
      // manually breaking sources in gen does not break `sbt compile`
      // Compile / managedSourceDirectories += baseDirectory.value / "gen",
      Compile / javaSource := baseDirectory.value / "gen",
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories += baseDirectory.value / "testResources",
      commands ++= Seq(lexer, parser)
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
// java -Xmx512m -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -jar ./gen/jflex-1.9.2.jar -d ./ge
//n/intellij/unison ./src/main/scala/intellij/unison/language/Unison.flex
def lexer: Command = Command.command("lexer") { state: State =>
  import jflex.Main.{main => jflexRun}
  val baseDir = state.configuration.baseDirectory()
  val srcDir = baseDir / "src" / "main" / "jflex"
  val flexFile = srcDir / "Unison.flex"
  val outDir = baseDir / "gen" / "intellij" / "unison"

  state.log.info(s"Generate lexer from $flexFile into $outDir")

  // fail fast on missing input
  if (!flexFile.exists()) {
    sys.error(s"Lexer generation failed: input .flex file not found: $flexFile")
  }
  IO.createDirectory(outDir)

  try {
    jflexRun(Array("-d", outDir.getAbsolutePath, flexFile.getAbsolutePath))
  } catch {
    // fail on generator error
    case t: Throwable =>
      sys.error("Lexer generation failed (JFlex threw an exception): " + t.getMessage)
  }
  state
}

def parser: Command = Command.command("parser") { state =>
  val baseDir = state.configuration.baseDirectory()
  val bnfFile = baseDir / "src" / "main" / "jflex" / "Unison.bnf"
  val outDir  = baseDir / "gen" // "intellij" / "unison"

  // 1) Locate IntelliJ SDK lib jars downloaded by sbt-idea-plugin
  val home = file(sys.props("user.home"))
  val sdkRoot = home / ".intellij-unisonPluginIC" / "sdk"

  // SDK dirs are typically like: ~/.intellij-unisonPluginIC/sdk/251.26927.53/
  val sdkLibDirOpt: Option[File] = {
    val candidates = (sdkRoot * "*").get
      .filter(_.isDirectory)
      .map(_ / "lib")
      .filter(_.isDirectory)

    // prefer the one that contains idea.jar
    val withIdeaJar = candidates.filter(d => (d / "idea.jar").exists())
    val pickFrom = if (withIdeaJar.nonEmpty) withIdeaJar else candidates

    pickFrom.sortBy(_.lastModified()).lastOption
  }

  val sdkLibDir = sdkLibDirOpt.getOrElse {
    sys.error(
      s"Could not find IntelliJ SDK lib dir under $sdkRoot/*/lib (with idea.jar). " +
        "Run `sbt runIDE` once or check sbt-idea-plugin cache location."
    )
  }

  val sdkJars: Seq[File] = (sdkLibDir * "*.jar").get

  // 2) Resolve grammar-kit jar(s) from the sbt classpath
  val extracted = Project.extract(state)
  val compileCp = extracted.runTask(Compile / dependencyClasspath, state)._2.map(_.data)
  val grammarKitJars = compileCp.filter(f => f.getName.contains("grammar-kit"))

  if (grammarKitJars.isEmpty)
    sys.error("No grammar-kit jar found on Compile / dependencyClasspath. Check project/build.sbt dependencies.")

  // 3) Fork a JVM with (grammar-kit + IntelliJ SDK jars) and run org.intellij.grammar.Main
  val cp = (grammarKitJars ++ sdkJars).distinct

  IO.createDirectory(outDir)

  val javaHome = sys.props.get("java.home").map(file).getOrElse(sys.error("java.home not set"))
  val javaBin = javaHome / "bin" / "java"

  val mainClass = "org.intellij.grammar.Main"
  val args = Seq(outDir.getAbsolutePath, bnfFile.getAbsolutePath)

  state.log.info(s"Generating parser: $bnfFile -> $outDir")
  state.log.info(s"Using IntelliJ SDK lib: ${sdkLibDir.getAbsolutePath}")
  state.log.info(s"Grammar-Kit jars: ${grammarKitJars.map(_.getName).mkString(", ")}")

  val forkOpts = ForkOptions()
    .withWorkingDirectory(baseDir)
    .withRunJVMOptions(Vector("-Xmx1g"))
    .withOutputStrategy(Some(StdoutOutput))
    .withRunJVMOptions(Vector(
      "-Didea.is.unit.test=true",
      "-Djava.awt.headless=true"
    ))

  val cpString = cp.map(_.getAbsolutePath).mkString(java.io.File.pathSeparator)

  val javaArgs: Seq[String] =
    Seq("-cp", cpString, "org.intellij.grammar.Main") ++ args

  val exit: Int = Fork.java(forkOpts, javaArgs)
  if (exit != 0) sys.error(s"Grammar-Kit failed with exit code $exit")
  else state
}

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
Test / fork := true
Test / javaOptions ++= Seq(
  "--add-opens=java.base/java.lang=ALL-UNNAMED",
  "--add-opens=java.base/java.util=ALL-UNNAMED",
  "--add-opens=java.base/java.io=ALL-UNNAMED",
  "--add-opens=java.base/java.nio=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens=java.base/jdk.internal.misc=ALL-UNNAMED",
  "--add-opens=java.desktop/javax.swing=ALL-UNNAMED",
  "--add-opens=java.desktop/java.awt=ALL-UNNAMED"
)

addCommandAlias("c", "clean;compile;")
addCommandAlias("t", "clean;compile;test")
addCommandAlias("r", "runIDE")
addCommandAlias("f", "scalafmtAll")
