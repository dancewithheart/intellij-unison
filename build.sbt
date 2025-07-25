import org.jetbrains.sbtidea.Keys.*

ThisBuild / scalaVersion := "2.13.16"

ThisBuild / intellijPluginName := "intellij-unison"
ThisBuild / intellijBuild := "251.27812.12"
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity

lazy val unison =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1",
      Compile / javacOptions ++= Seq("--release", "17"),
      Compile / scalacOptions ++= Seq("--release", "17"),
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies ++= Seq(),
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories += baseDirectory.value / "testResources",
    )