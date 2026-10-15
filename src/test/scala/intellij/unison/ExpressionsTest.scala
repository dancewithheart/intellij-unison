package intellij.unison

class ExpressionsTest
    extends BaseUnisonTest {

  def testLiterals(): Unit = runTests()

  def testBoolExpression3(): Unit = runTests()

  def testBoolExpression2(): Unit = runTests()

  def testNumericalExpression1(): Unit = runKnownBrokenTests()

  def testIfThenElseExpression1(): Unit = runTests()

  def testNumericalExpression3(): Unit = runKnownBrokenTests()

  def testAnonymousLambda(): Unit = runTests()

  def testAnonymousLambda2Params(): Unit = runTests()
}
