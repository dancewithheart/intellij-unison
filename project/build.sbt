resolvers ++= Seq(
  "IntelliJ Deps Repository" at "https://packages.jetbrains.team/maven/p/ij/intellij-dependencies/",
  "IntelliJ Releases Repository" at "https://www.jetbrains.com/intellij-repository/releases/"
)
libraryDependencies ++= Seq(
  "org.jetbrains.intellij.deps.jflex" % "jflex" % "1.10.18",
  "org.jetbrains" % "grammar-kit" % "2023.3.4" // issues with deps
)
