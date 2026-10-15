package intellij.unison

import org.junit.Assert.{assertEquals, assertNotNull}

class ExpressionRegressionTest extends BaseUnisonTest {

  def testBoolExpression1(): Unit = {
    doTest(false)

    assertEquals(
      Vector.empty[String],
      getErrors.map(_.getErrorDescription)
    )

    assertEquals(
      Vector(
        "n = 4",
        "x1 = 0 === n",
        "x2 = (1 + 1) === 2",
        "x3 = (n + 1) === 2",
        "x4 = 2 === (n + 1)",
        "x5 = mod n 2 === 0",
        "x6 = 0 === (mod n 2)",
        "x7 = n === 0"
      ),
      getBindings
    )
  }

  def testIfThenElseExpression2(): Unit = {
    doTest(false)

    assertEquals(
      Vector.empty[String],
      getErrors.map(_.getErrorDescription)
    )

    assertEquals(
      Vector(
        "isEven num =\n" +
          "  if mod num 2 === 0 then \"even\" else \"odd\""
      ),
      getBindings
    )
  }

  def testAnonymousLambda2Params(): Unit = {
    runTests()

    val lambda = getLambda

    assertNotNull("Expected a lambda expression", lambda)
    assertEquals(
      Vector("acc", "a"),
      getLambdaParams(lambda)
    )

    val body = getLambdaBody(lambda)
    assertNotNull("Expected a lambda body", body)
    assertEquals("a Nat.+ acc", body.getText)
  }
}
