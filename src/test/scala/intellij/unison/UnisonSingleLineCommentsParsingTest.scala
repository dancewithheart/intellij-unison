package intellij.unison

import com.intellij.testFramework.ParsingTestCase
import intellij.unison.language.UnisonParserDefinition

class UnisonSingleLineCommentsParsingTest
    extends ParsingTestCase("", "u", new UnisonParserDefinition()) {

  def testComments(): Unit = doTest(true)

  override def getTestDataPath: String = "src/test/testData"

  override def includeRanges(): Boolean = true
}
