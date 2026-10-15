package intellij.unison

class WipTest
    extends BaseUnisonTest {

  override def getTestDataPath: String = "src/test/testData/wip"

  override def runTests(): Unit = runKnownBrokenTests()

  def testConstructorPatterns(): Unit = runTests()

  def testCasesSyntax(): Unit = runTests()

  def testDelayedComputation(): Unit = runTests()

  def testListPatterns(): Unit = runTests()

  def testRecordTypes(): Unit = runTests()

  def testExceptionsHandling2(): Unit = runTests()

  def testNestedIfThenElse(): Unit = runTests()

  def testListExpressions(): Unit = runTests()

  def testUseAbilities(): Unit = runTests()
}
