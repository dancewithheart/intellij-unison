package intellij.unison

import org.junit.Assert.{assertEquals, assertTrue}

class ParserRecoveryTest extends BaseUnisonTest {

  override def getTestDataPath: String = "src/test/testData/recovery"

  def testBrokenAssignmentEofRecovery(): Unit = {
    doTest(false)

    // The invalid assignment must produce a parser error.
    assertEquals(
      Vector("Expression expected after '='"),
      getErrors.map(_.getErrorDescription)
    )
  }

  def testBrokenAssignmentRecovery(): Unit = {
    // Parse the .u fixture, without comparing against a .txt snapshot.
    doTest(false)

    // The invalid assignment must produce a parser error.
    assertEquals(
      Vector("Expression expected after '='"),
      getErrors.map(_.getErrorDescription)
    )

    // The following valid declaration must still be parsed.
    assertTrue(
      "Parser failed to recover and parse 'good = 42'",
      getBindings.exists(_ == "good = 42")
    )
  }
}
