package intellij.unison

class WipTest
    extends BaseUnisonTest {

  override def getTestDataPath: String = "src/test/testData/wip"

  def testAnonymousLambda2Params(): Unit = runTests()

  def testConstructorPatterns(): Unit = runTests()

  def testCasesSyntax(): Unit = runTests()

  def testHello(): Unit = runTests()

  def testDelayedComputation(): Unit = runTests()

  def testListPatterns(): Unit = runTests()

  def testRecordTypes(): Unit = runTests()

  def testPolymorphicTypes(): Unit = runTests()

  def testExceptionsHandling(): Unit = runTests()

  def testPatternMatchGuards1(): Unit = runTests()

  def testPatternMatchGuards2(): Unit = runTests()

  def testPatternMatchGuards3(): Unit = runTests()

  def testNestedImports(): Unit = runTests()

  def testNestedFunctions(): Unit = runTests()

  def testNestedIfThenElse(): Unit = runTests()

  def testListExpressions(): Unit = runTests()

  def testUseAbilities(): Unit = runTests()
}
