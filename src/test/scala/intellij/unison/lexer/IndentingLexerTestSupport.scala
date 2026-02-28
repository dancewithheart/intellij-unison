package intellij.unison.lexer

import com.intellij.lexer.Lexer
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

final case class Lexed(tok: String, text: String, start: Int, end: Int)

object IndentingLexerTestSupport {

  /** Collect all tokens (including WHITE_SPACE if you want) */
  def lexAll(input: String, lexer: Lexer, includeWhitespace: Boolean = false): Vector[Lexed] = {
    lexer.start(input)

    val b = Vector.newBuilder[Lexed]
    while (lexer.getTokenType != null) {
      val tpe = lexer.getTokenType
      val start = lexer.getTokenStart
      val end = lexer.getTokenEnd
      val text = input.substring(start, end)

      if (includeWhitespace || tpe != TokenType.WHITE_SPACE)
        b += Lexed(tokenName(tpe), text, start, end)

      lexer.advance()
    }
    b.result()
  }

  private def tokenName(t: IElementType): String = {
    val s = t.toString
    // examples: "UnisonTokenType.NEWLINE", "WHITE_SPACE", "UnisonTokenType.IDENTIFIER_TOKEN"
    s.stripPrefix("UnisonTokenType.")
  }
}
