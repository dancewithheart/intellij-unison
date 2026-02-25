import org.jetbrains.sbtidea.Keys.*
import jflex.Main.{main => jflexRun}

ThisBuild / scalaVersion := "2.13.18"

ThisBuild / intellijPluginName := "intellij-unison"
ThisBuild / intellijBuild := "251.26927.53"
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity

val junitInterfaceVersion = "0.13.3"
val opentest4jVersion = "1.3.0"
val junitVersion = "4.13.2"

lazy val unison =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1",
      Compile / javacOptions ++= Seq("--release", "17"),
      Compile / scalacOptions ++= Seq("--release", "17"),
      compileOrder := CompileOrder.Mixed,
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies ++= Seq(
        "com.github.sbt" % "junit-interface" % junitInterfaceVersion % Test,
        "org.opentest4j" % "opentest4j" % opentest4jVersion % Test,
        "junit" % "junit" % junitVersion % Test,
        "dev.zio" %% "zio-test"     % "2.0.21" % Test,
        "dev.zio" %% "zio-test-sbt" % "2.0.21" % Test
      ),
      // manually breaking sources in gen does not break `sbt compile`
      // Compile / managedSourceDirectories += baseDirectory.value / "gen",
      Compile / javaSource := baseDirectory.value / "gen",
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories += baseDirectory.value / "testResources",
      commands ++= Seq(lexer)
    )

// https://github.com/dlwh/sbt-jflex uses old version of JFlex
// manually one can download JFlex modified by IntelliJ and run
// java -Xmx512m -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -jar ./gen/jflex-1.9.2.jar -d ./ge
//n/intellij/unison ./src/main/scala/intellij/unison/language/Unison.flex
def lexer: Command = Command.command("lexer") { state: State =>
  val baseDir = state.configuration.baseDirectory()
  val srcDir = s"$baseDir/src/main/scala"
  val flexFilePath = s"$srcDir/intellij/unison/language/Unison.flex"
  val outDir = s"$baseDir/gen/intellij/unison"
  println(s"Generate lexer from $flexFilePath into $outDir")
  jflexRun(Array("-d", outDir, flexFilePath))
  state
}

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
