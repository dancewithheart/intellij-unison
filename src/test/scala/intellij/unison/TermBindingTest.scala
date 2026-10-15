package intellij.unison

import org.junit.Assert.assertEquals

class TermBindingTest
    extends BaseUnisonTest {

  def testTermBindingBasicTypesBoolean(): Unit = {
    runTests() // Snapshot comparison + no PsiErrorElement

    assertEquals(
      Vector("go1 = true", "go2 = false"),
      getBindings
    )
  }

  def testTermBindingBasicTypesBytes(): Unit = runTests()

  def testTermBindingBasicTypesFloat(): Unit = runTests()

  def testTermBindingBasicTypesChar(): Unit = runTests()

  def testTermBindingBasicTypesText(): Unit = runTests()

  def testTermBindingMultilineText(): Unit = runTests()

  def testTermBindingBasicTypesInt(): Unit = runTests()

  def testTermBindingTuples(): Unit = runTests()

  def testTermBindingFunction(): Unit = runTests()

  def testTermBindingFunction2(): Unit = runTests()
}
