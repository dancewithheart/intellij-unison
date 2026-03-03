package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.{FlexAdapter, Lexer}
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes
import intellij.unison.lexer.IndentingLexerTestSupport._

object IndentingLexerDedentAnchorSpec
    extends ZIOSpecDefault {

  private def mk: Lexer =
    new IndentingLexer(new FlexAdapter(new UnisonLexer(null)))

  private def dump(out: Vector[Lexed]): String =
    "\nTOKENS:\n" + IndentingLexerTestSupport.render(out)

  private def lastDedentText(toks: Vector[Lexed]): Option[String] =
    lastTextOf(toks, UnisonTypes.DEDENT)

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexerDedentAnchor")(
      test("eofDedentMustNotConsumeRealChars") {
        // NOTE: no trailing newline; final char is a quote.
        val code =
          """|matchNum1 : Nat -> Text
             |matchNum1 num = match num with
             |  one -> "one"|""".stripMargin

        val toks = lexAll(code, mk, includeWhitespace = true)
        val dedentTextOpt = lastDedentText(toks)

        val ok =
          dedentTextOpt.isDefined && {
            val dedentText = dedentTextOpt.get
            // Before the change, DEDENT often becomes the last character like "\"" or "t"
            !(dedentText == "\"" || dedentText == "t" || dedentText.matches("[A-Za-z0-9_]+"))
          }

        assertTrue(ok).label(s"dedentTextOpt=$dedentTextOpt" + dump(toks))
      },
      test("crlfNewlineIsHandledAndAnchorsDedent") {
        // Windows-style newlines; no trailing newline at EOF.
        val code =
          "x = 1\r\n" +
            "cases\r\n" +
            "  n\r\n" +
            "    | otherwise -> \"t\""

        val toks = lexAll(code, mk, includeWhitespace = true)

        val hasNewline = toks.exists(_.tpe == UnisonTypes.NEWLINE)
        val dedentTextOpt = lastDedentText(toks)

        val ok =
          hasNewline &&
            dedentTextOpt.isDefined &&
            (dedentTextOpt.get != "\"") // DEDENT must not consume the trailing quote

        assertTrue(ok).label(s"hasNewline=$hasNewline dedentTextOpt=$dedentTextOpt" + dump(toks))
      }
    )
}
