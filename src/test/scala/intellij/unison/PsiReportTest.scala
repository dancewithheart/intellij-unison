package intellij.unison

import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.ParsingTestCase.toParseTreeText

import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.{Files, Path, Paths}

import scala.jdk.CollectionConverters._

class PsiReportTest extends BaseUnisonTest {

  def testGenerateReports(): Unit = {
    val root = Paths.get(getTestDataPath)

    generateReports(root)
    generateReports(root.resolve("wip"))
  }

  private def generateReports(directory: Path): Unit = {
    val stream = Files.list(directory)

    val inputs =
      try {
        stream.iterator().asScala
          .filter(path =>
            Files.isRegularFile(path) &&
              path.getFileName.toString.endsWith(".u")
          )
          .toVector
          .sortBy(_.getFileName.toString)
      } finally {
        stream.close()
      }

    inputs.foreach { input =>
      val filename = input.getFileName.toString
      val name = filename.stripSuffix(".u")

      println(s"[PSI] Parsing ${input.toAbsolutePath}")

      val source = ParsingTestCase.loadFileDefault(
        directory.toString,
        filename
      )

      val file = parseFile(name, source)

      val psi =
        toParseTreeText(file, skipSpaces(), includeRanges()).trim

      val output = directory.resolve(s"$name.txt")
      val _ = Files.writeString(output, psi, UTF_8)

      println(s"[PSI] Generated $output")
    }
  }
}
