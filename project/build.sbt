// Allow to run JFlex in project build.sbt
resolvers ++= Seq(
  "IntelliJ Deps Repository" at "https://packages.jetbrains.team/maven/p/ij/intellij-dependencies/"
)
libraryDependencies ++= Seq("org.jetbrains.intellij.deps.jflex" % "jflex" % "1.9.2")
