package intellij.unison

import com.intellij.testFramework.ParsingTestCase
import intellij.unison.language.UnisonParserDefinition

abstract class BaseUnisonTest
    extends ParsingTestCase("", "u", new UnisonParserDefinition()) {

  override def getTestDataPath: String = "src/test/testData"

  override def includeRanges(): Boolean = true

  def runTests(): Unit = doTest(true)
}
