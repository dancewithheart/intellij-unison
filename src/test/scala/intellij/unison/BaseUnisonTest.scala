package intellij.unison

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.ParsingTestCase.toParseTreeText
import intellij.unison.language.UnisonParserDefinition
import intellij.unison.language.psi.{UnisonBinding, UnisonExpression, UnisonLambda, UnisonPattern}

import scala.jdk.CollectionConverters._

abstract class BaseUnisonTest
    extends ParsingTestCase("", "u", new UnisonParserDefinition()) {

  override def getTestDataPath: String = "src/test/testData"

  override def includeRanges(): Boolean = true

  // Verify golden PSI trees AND reject unexpected parser error nodes.
  def runTests(): Unit = doTest(true, true)

  // Known parser gaps still have golden snapshots, but may contain PSI errors.
  def runKnownBrokenTests(): Unit = doTest(true)

  def printOutTree(): Unit = {
    println(
      "\n=== RECOVERY PSI TREE ===\n" +
        toParseTreeText(myFile, false, true)
    )
  }

  def getErrors: Vector[PsiErrorElement] = {
    PsiTreeUtil
      .findChildrenOfType(myFile, classOf[PsiErrorElement])
      .asScala
      .toVector
  }

  def getBindings: Vector[String] = {
    PsiTreeUtil
      .findChildrenOfType(myFile, classOf[UnisonBinding])
      .asScala
      .map(_.getText)
      .toVector
  }

  def getLambdaBody(lambda: UnisonLambda) = {
    PsiTreeUtil.getChildOfType(
      lambda,
      classOf[UnisonExpression]
    )
  }

  def getLambdaParams(lambda: UnisonLambda) = {
    lambda.getChildren.collect {
      case p: UnisonPattern => p.getText
    }.toVector
  }

  def getLambda = {
    PsiTreeUtil.findChildOfType(
      myFile,
      classOf[UnisonLambda]
    )
  }
}
