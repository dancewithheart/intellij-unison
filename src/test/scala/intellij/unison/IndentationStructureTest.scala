package intellij.unison

import intellij.unison.language.psi.UnisonStatement
import org.junit.Assert._

class IndentationStructureTest extends BaseUnisonTest {

  def testDedentClosesNestedBlock(): Unit = {
    val source =
      """|outer =
         |  inner = 1
         |  inner
         |next = 2""".stripMargin

    val _ = parseFile("IndentationStructure", source)

    assertTrue(
      s"Unexpected PSI errors: $getErrors",
      getErrors.isEmpty
    )

    val statements = myFile.getChildren.collect {
      case s: UnisonStatement => s
    }.toVector

    // Two top-level declarations, not one.
    assertEquals(2, statements.size)

    // The nested binding belongs to outer.
    assertTrue(
      statements.head.getText.contains("inner = 1")
    )

    // The next declaration is outside outer.
    assertTrue(
      statements(1).getText.startsWith("next = 2")
    )

    assertFalse(
      statements.head.getText.contains("next = 2")
    )
  }
}
