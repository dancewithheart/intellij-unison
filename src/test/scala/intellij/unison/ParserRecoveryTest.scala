package intellij.unison

import org.junit.Assert.assertTrue

class ParserRecoveryTest extends BaseUnisonTest {

  override def getTestDataPath: String = "src/test/testData/recovery"

  def testBrokenAssignmentEofRecovery(): Unit = {
    doTest(false)

    // The invalid assignment must produce a parser error.
    assertTrue(
      "Expected a syntax error for 'broken ='",
      getErrors.nonEmpty
    )
  }

  def testBrokenAssignmentRecovery(): Unit = {
    // Parse the .u fixture, without comparing against a .txt snapshot.
    doTest(false)

    // The invalid assignment must produce a parser error.
    assertTrue(
      "Expected a syntax error for 'broken ='",
      getErrors.nonEmpty
    )

    // The following valid declaration must still be parsed.
    assertTrue(
      "Parser failed to recover and parse 'good = 42'",
      getBindings.exists(_ == "good = 42")
    )
  }
}
