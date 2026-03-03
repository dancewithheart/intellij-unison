package intellij.unison.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.unison.language.psi.UnisonTypes

/** Deterministic base lexer for IndentingLexer property tests:
  *   - groups whitespace into TokenType.WHITE_SPACE
  *   - groups non-whitespace into CodeTok
  *   - emits '(' and ')' as LPAREN/RPAREN tokens (so IndentingLexer can track parenDepth)
  */
final class FakeWhitespaceLexer
    extends LexerBase {

  private var buf: CharSequence = ""
  private var end: Int = 0
  private var pos: Int = 0

  private var tokenType: IElementType = null
  private var tokenStart: Int = 0
  private var tokenEnd: Int = 0

  // Pick any "regular" token from your grammar (must not be WHITE_SPACE/NEWLINE/INDENT/DEDENT).
  private val CodeTok: IElementType = UnisonTypes.IDENTIFIER

  override def start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int): Unit = {
    buf = buffer
    pos = startOffset
    end = endOffset
    advance() // prime first token
  }

  override def getState: Int = 0
  override def getBufferSequence: CharSequence = buf
  override def getBufferEnd: Int = end

  override def getTokenType: IElementType = tokenType
  override def getTokenStart: Int = tokenStart
  override def getTokenEnd: Int = tokenEnd

  override def advance(): Unit = {
    if (pos >= end) { tokenType = null; return }

    ch(pos) match {
      case '(' => emit1(UnisonTypes.LPAREN)
      case ')' => emit1(UnisonTypes.RPAREN)
      case c   =>
        val tpe = if (isWs(c)) TokenType.WHITE_SPACE else CodeTok
        val next = scanUntilBoundary(tpe, from = pos)
        emit(tpe, pos, next)
        pos = next
    }
  }

  // ---- small helpers ----

  private def ch(i: Int): Char = buf.charAt(i)

  private def isWs(c: Char): Boolean =
    c == ' ' || c == '\t' || c == '\n' || c == '\r'

  private def isParen(c: Char): Boolean =
    c == '(' || c == ')'

  /** Boundary means: stop *before* this char (so it begins the next token). */
  private def isBoundary(current: IElementType, c: Char): Boolean =
    isParen(c) || (current == TokenType.WHITE_SPACE && !isWs(c)) || (current != TokenType.WHITE_SPACE && isWs(c))

  /** Find first index > from where a boundary starts; or end if none. */
  private def scanUntilBoundary(current: IElementType, from: Int): Int =
    (from until end).find(i => i != from && isBoundary(current, ch(i))).getOrElse(end)

  private def emit1(tpe: IElementType): Unit = {
    emit(tpe, pos, pos + 1)
    pos += 1
  }

  private def emit(tpe: IElementType, s: Int, e: Int): Unit = {
    tokenType = tpe
    tokenStart = s
    tokenEnd = e
  }
}
