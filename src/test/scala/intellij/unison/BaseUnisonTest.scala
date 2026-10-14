package intellij.unison

import com.intellij.testFramework.ParsingTestCase
import intellij.unison.language.UnisonParserDefinition

abstract class BaseUnisonTest
    extends ParsingTestCase("", "u", new UnisonParserDefinition()) {

  override def getTestDataPath: String = "src/test/testData"

  override def includeRanges(): Boolean = true

  // Verify golden PSI trees AND reject unexpected parser error nodes.
  def runTests(): Unit = doTest(true, true)

  // Known parser gaps still have golden snapshots, but may contain PSI errors.
  def runKnownBrokenTests(): Unit = doTest(true)
}
