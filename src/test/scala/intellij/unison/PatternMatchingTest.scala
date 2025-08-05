package intellij.unison

class PatternMatchingTest
    extends BaseUnisonTest {

  def testLiteralPatterns(): Unit = runTests()

  def testAsPatterns(): Unit = runTests()

  def testConstructorPatterns(): Unit = runTests()

  def testListPatterns(): Unit = runTests()

  def testTuplePatterns(): Unit = runTests()

  def testPatternMatchGuards(): Unit = runTests()

  def testCasesSyntax(): Unit = runTests()
}
