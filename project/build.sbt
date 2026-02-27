resolvers ++= Seq(
  "IntelliJ Deps Repository" at "https://packages.jetbrains.team/maven/p/ij/intellij-dependencies/",
  "IntelliJ Releases Repository" at "https://www.jetbrains.com/intellij-repository/releases/"
)
libraryDependencies ++= Seq(
  "org.jetbrains.intellij.deps.jflex" % "jflex" % "1.9.2",
  "org.jetbrains" % "grammar-kit" % "2023.3", // isses with deps
  "com.jetbrains.intellij.java" % "java-psi" % "251.26927.90"
)
