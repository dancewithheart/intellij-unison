package intellij.unison

class PatternMatchingTest
    extends BaseUnisonTest {

  def testLiteralPatterns(): Unit = runTests()

  def testTuplePatterns1(): Unit = runTests()

  def testTuplePatterns2(): Unit = runTests()

  def testMultiplePatterns(): Unit = runTests()

  def testAsPatterns(): Unit = runTests()

  def testPatternMatchGuards1(): Unit = runTests()

  def testPatternMatchGuards3(): Unit = runTests()

  def testCasesExpr(): Unit = runTests()
}
