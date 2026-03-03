package intellij.unison.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.psi.tree.IElementType
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes
import org.junit.Assert._
import org.junit.Test

final class IndentingLexerDedentAnchorTest {

  private def lex(code: String): Vector[(IElementType, Int, Int, String)] = {
    val base = new FlexAdapter(new UnisonLexer(null))
    val lexer = new IndentingLexer(base)

    lexer.start(code, 0, code.length, 0)

    val b = Vector.newBuilder[(IElementType, Int, Int, String)]
    while (lexer.getTokenType != null) {
      val tpe = lexer.getTokenType
      val s = lexer.getTokenStart
      val e = lexer.getTokenEnd
      val txt = code.substring(s, e)
      b += ((tpe, s, e, txt))
      lexer.advance()
    }
    b.result()
  }

  @Test
  def eofDedentMustNotConsumeRealChars(): Unit = {
    // NOTE: no trailing newline; final char is a quote.
    val code =
      "matchNum1 : Nat -> Text\n" +
        "matchNum1 num = match num with\n" +
        "  one -> \"one\""

    val toks = lex(code)

    val lastDedentOpt = toks.reverse.find(_._1 == UnisonTypes.DEDENT)
    assertTrue("Expected at least one DEDENT at EOF", lastDedentOpt.isDefined)

    val (_, _, _, dedentText) = lastDedentOpt.get

    // Before the change, DEDENT often becomes the last character like "\"" or "t"
    assertFalse(
      s"DEDENT must not consume a real character, got text=[$dedentText]",
      dedentText == "\"" || dedentText == "t" || dedentText.matches("[A-Za-z0-9_]+")
    )
  }

  @Test
  def crlfNewlineIsHandledAndAnchorsDedent(): Unit = {
    // Windows-style newlines; no trailing newline at EOF.
    val code =
      "x = 1\r\n" +
        "cases\r\n" +
        "  n\r\n" +
        "    | otherwise -> \"t\""

    val toks = lex(code)

    val hasNewline = toks.exists(_._1 == UnisonTypes.NEWLINE)
    assertTrue("Expected NEWLINE tokens", hasNewline)

    val lastDedentOpt = toks.reverse.find(_._1 == UnisonTypes.DEDENT)
    assertTrue("Expected DEDENT at EOF", lastDedentOpt.isDefined)

    val (_, _, _, dedentText) = lastDedentOpt.get
    assertFalse(
      s"DEDENT must not consume the trailing quote, got text=[$dedentText]",
      dedentText == "\""
    )
  }
}
