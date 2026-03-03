package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.{FlexAdapter, Lexer}
import com.intellij.psi.TokenType
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes
import intellij.unison.lexer.IndentingLexerTestSupport._

object IndentingLexerCasesDedentSpec extends ZIOSpecDefault {

  private def mk: Lexer =
    new IndentingLexer(new FlexAdapter(new UnisonLexer(null)))

  private def dump(out: Vector[Lexed]): String =
    "\nTOKENS:\n" + IndentingLexerTestSupport.render(out)

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexerCasesDedent")(
      test("casesBlockEmitsTwoDedentsBeforeTopLevelX") {
        val code =
          """|mkErr : Exception
             |mkErr = failure "Zero was found"
             |
             |nonZero : Nat ->  { Exception } Nat
             |nonZero = cases
             |  n
             |    | n Nat.== 0  -> mkErr
             |    | otherwise   -> n
             |
             |x = catch do nonZero 0
             |""".stripMargin

        val toks = lexAll(code, mk, includeWhitespace = true)

        val xIdx = toks.indexWhere(t => t.tpe == UnisonTypes.IDENTIFIER_TOKEN && t.text == "x")

        val dedentsBeforeX =
          if (xIdx < 0) -1
          else
            countDedentsImmediatelyBefore(
              tokens = toks,
              index = xIdx,
              isSkippable = t => t.tpe == TokenType.WHITE_SPACE || t.tpe == UnisonTypes.NEWLINE
            )

        assertTrue(xIdx >= 0 && dedentsBeforeX == 2)
          .label(s"xIdx=$xIdx dedentsBeforeX=$dedentsBeforeX" + dump(toks))
      }
    )
}
