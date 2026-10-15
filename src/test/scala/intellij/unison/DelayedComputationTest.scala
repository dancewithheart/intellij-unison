package intellij.unison

import org.junit.Assert.assertEquals

class DelayedComputationTest extends BaseUnisonTest {

  def testDelayedHello(): Unit = {
    doTest(false)

    assertEquals(
      "Unexpected parser errors",
      Vector.empty[String],
      getErrors.map(_.getErrorDescription)
    )

    assertEquals(
      Vector("hello = do printLine \"Hello World in Unison!\""),
      getBindings
    )
  }

  def testApplicationPrecedence(): Unit = {
    doTest(false)

    assertEquals(
      Vector.empty[String],
      getErrors.map(_.getErrorDescription)
    )

    assertEquals(
      Vector(
        "simple = printLine \"Hello\"",
        "numeric = 1 + 2",
        "mixed = f x + g y"
      ),
      getBindings
    )

    printOutTree()
  }
}
