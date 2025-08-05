package intellij.unison

class ExpressionsTest
    extends BaseUnisonTest {

  def testLiterals(): Unit = runTests()
  def testNestedImports(): Unit = runTests()
  def testNestedFunctions(): Unit = runTests()
  def testNestedIfThenElse(): Unit = runTests()
  def testNumericalExpression(): Unit = runTests()
  def testAnonymousLambda2Params(): Unit = runTests()
}
