package intellij.unison

class WipTest extends BaseUnisonTest {

  override def getTestDataPath: String = "src/test/testData/wip"

  def testAnonymousLambda2Params(): Unit = runTests()

  def testAsPatterns(): Unit = runTests()

  def testConstructorPatterns(): Unit = runTests()

  def testCasesSyntax(): Unit = runTests()

  def testHello(): Unit = runTests()

  def testDelayedComputation(): Unit = runTests()

  def testListPatterns(): Unit = runTests()

  def testPatternMatchGuards(): Unit = runTests()

  def testNestedImports(): Unit = runTests()

  def testNestedFunctions(): Unit = runTests()

  def testNestedIfThenElse(): Unit = runTests()
}
