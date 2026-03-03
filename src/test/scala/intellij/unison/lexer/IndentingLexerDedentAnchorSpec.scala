package intellij.unison.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.psi.tree.IElementType
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes
import zio.test._

object IndentingLexerDedentAnchorSpec extends ZIOSpecDefault {

  private def lex(code: String): Vector[(IElementType, Int, Int, String)] = {
    val base  = new FlexAdapter(new UnisonLexer(null))
    val lexer = new IndentingLexer(base)

    lexer.start(code, 0, code.length, 0)

    val b = Vector.newBuilder[(IElementType, Int, Int, String)]
    while (lexer.getTokenType != null) {
      val tpe = lexer.getTokenType
      val s   = lexer.getTokenStart
      val e   = lexer.getTokenEnd
      val txt = code.substring(s, e)
      b += ((tpe, s, e, txt))
      lexer.advance()
    }
    b.result()
  }

  private def lastDedentText(toks: Vector[(IElementType, Int, Int, String)]): Option[String] =
    toks.reverseIterator.collectFirst { case (tpe, _, _, txt) if tpe == UnisonTypes.DEDENT => txt }

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexerDedentAnchor")(
      test("eofDedentMustNotConsumeRealChars") {
        // NOTE: no trailing newline; final char is a quote.
        val code =
          "matchNum1 : Nat -> Text\n" +
            "matchNum1 num = match num with\n" +
            "  one -> \"one\""

        val toks = lex(code)
        val dedentTextOpt = lastDedentText(toks)

        assertTrue(dedentTextOpt.isDefined) &&
          assertTrue {
            val dedentText = dedentTextOpt.get
            // Before the change, DEDENT often becomes the last character like "\"" or "t"
            !(dedentText == "\"" || dedentText == "t" || dedentText.matches("[A-Za-z0-9_]+"))
          }
      },

      test("crlfNewlineIsHandledAndAnchorsDedent") {
        // Windows-style newlines; no trailing newline at EOF.
        val code =
          "x = 1\r\n" +
            "cases\r\n" +
            "  n\r\n" +
            "    | otherwise -> \"t\""

        val toks = lex(code)

        val hasNewline = toks.exists(_._1 == UnisonTypes.NEWLINE)
        val dedentTextOpt = lastDedentText(toks)

        assertTrue(hasNewline) &&
          assertTrue(dedentTextOpt.isDefined) &&
          assertTrue {
            val dedentText = dedentTextOpt.get
            // DEDENT must not consume the trailing quote
            dedentText != "\""
          }
      }
    )
}
