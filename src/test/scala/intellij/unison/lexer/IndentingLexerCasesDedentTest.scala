package intellij.unison.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes
import org.junit.Assert._
import org.junit.Test

final class IndentingLexerCasesDedentTest {

  private def lex(code: String): Vector[(IElementType, Int, Int, String)] = {
    val base = new FlexAdapter(new UnisonLexer(null))
    val lexer = new IndentingLexer(base)
    lexer.start(code, 0, code.length, 0)

    val b = Vector.newBuilder[(IElementType, Int, Int, String)]
    while (lexer.getTokenType != null) {
      val t = lexer.getTokenType
      val s = lexer.getTokenStart
      val e = lexer.getTokenEnd
      b += ((t, s, e, code.substring(s, e)))
      lexer.advance()
    }
    b.result()
  }

  @Test
  def casesBlockEmitsTwoDedentsBeforeTopLevelX(): Unit = {
    val code =
      "mkErr : Exception\n" +
        "mkErr = failure \"Zero was found\"\n" +
        "\n" +
        "nonZero : Nat ->  { Exception } Nat\n" +
        "nonZero = cases\n" +
        "  n\n" +
        "    | n Nat.== 0  -> mkErr\n" +
        "    | otherwise   -> n\n" +
        "\n" +
        "x = catch do nonZero 0\n"

    val toks = lex(code)

    // Find the 'x' identifier token
    val xIdx = toks.indexWhere { case (t, _, _, txt) =>
      t == UnisonTypes.IDENTIFIER_TOKEN && txt == "x"
    }
    assertTrue("Expected an identifier token 'x'", xIdx >= 0)

    // Count consecutive DEDENT tokens immediately before x (ignoring whitespace/newlines)
    var i = xIdx - 1
    while (i >= 0 && (toks(i)._1 == TokenType.WHITE_SPACE || toks(i)._1 == UnisonTypes.NEWLINE)) i -= 1

    var dedents = 0
    while (i >= 0 && toks(i)._1 == UnisonTypes.DEDENT) { dedents += 1; i -= 1 }

    assertEquals("Expected two DEDENTs before returning to top-level", 2.toLong, dedents.toLong)
  }
}
