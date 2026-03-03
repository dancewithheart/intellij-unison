package intellij.unison.lexer

import com.intellij.lexer.Lexer
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

final case class Lexed(tpe: IElementType, name: String, text: String, start: Int, end: Int)

object IndentingLexerTestSupport {

  /** Collect all tokens (optionally including WHITE_SPACE). */
  def lexAll(input: String, lexer: Lexer, includeWhitespace: Boolean = false): Vector[Lexed] = {
    lexer.start(input, 0, input.length, 0)

    val b = Vector.newBuilder[Lexed]
    while (lexer.getTokenType != null) {
      val tpe   = lexer.getTokenType
      val start = lexer.getTokenStart
      val end   = lexer.getTokenEnd
      val text  = input.substring(start, end)

      if (includeWhitespace || tpe != TokenType.WHITE_SPACE) {
        b += Lexed(tpe, tokenName(tpe), text, start, end)
      }

      lexer.advance()
    }
    b.result()
  }

  /** Stable-ish human name for assertions/debug output. */
  def tokenName(t: IElementType): String =
    t.toString.stripPrefix("UnisonTokenType.")

  /** Pretty printer for failure messages. */
  def render(tokens: Seq[Lexed], max: Int = 300): String = {
    val shown = tokens.take(max).zipWithIndex.map { case (t, i) =>
      val txt = escape(t.text)
      f"$i%03d ${t.name} [${t.start}%d..${t.end}%d] '$txt'"
    }
    val suffix = if (tokens.size > max) s"\n... (${tokens.size - max} more)" else ""
    shown.mkString("\n") + suffix
  }

  def renderAround(tokens: Seq[Lexed], index: Int, radius: Int = 8): String = {
    val from = Math.max(0, index - radius)
    val to   = Math.min(tokens.size, index + radius + 1)
    render(tokens.slice(from, to).zipWithIndex.map { case (t, i) =>
      // reindex for local context display
      t.copy(name = s"${from + i}:${t.name}")
    }, max = Int.MaxValue)
  }

  private def escape(s: String): String =
    s.flatMap {
      case '\n' => "\\n"
      case '\r' => "\\r"
      case '\t' => "\\t"
      case c    => c.toString
    }

  // ---- Common helpers used in tests ----

  def indexOf(tokens: Seq[Lexed])(p: Lexed => Boolean): Int =
    tokens.indexWhere(p)

  def countDedentsImmediatelyBefore(
                                     tokens: IndexedSeq[Lexed],
                                     index: Int,
                                     isSkippable: Lexed => Boolean
                                   ): Int = {
    var i = index - 1
    while (i >= 0 && isSkippable(tokens(i))) i -= 1
    var n = 0
    while (i >= 0 && tokens(i).name == "DEDENT") { n += 1; i -= 1 }
    n
  }

  def indexOfIdentifier(tokens: Seq[Lexed], name: String, tpe: IElementType): Int =
    tokens.indexWhere(t => t.tpe == tpe && t.text == name)

  def countDedentsBeforeTopLevel(
                                  tokens: IndexedSeq[Lexed],
                                  index: Int,
                                  isSkippable: Lexed => Boolean
                                ): Int =
    countDedentsImmediatelyBefore(tokens, index, isSkippable)
}
