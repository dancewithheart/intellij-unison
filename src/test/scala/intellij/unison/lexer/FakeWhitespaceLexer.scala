package intellij.unison.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.unison.language.psi.UnisonTypes

/** Deterministic base lexer for IndentingLexer property tests:
  *   - groups whitespace into TokenType.WHITE_SPACE
  *   - groups other chars into a single "CODE" token type (we reuse IDENTIFIER if you have one; otherwise create a
  *     simple IElementType in tests)
  *   - optionally emits LPAREN/RPAREN tokens for '(' and ')'
  */
final class FakeWhitespaceLexer
    extends LexerBase {
  private var buf: CharSequence = ""
//  private var start: Int = 0
  private var end: Int = 0
  private var pos: Int = 0

  private var tokenType: IElementType = null
  private var tokenStart: Int = 0
  private var tokenEnd: Int = 0

  // Use an existing token from your grammar so you don't need a new IElementType.
  // If you don't have IDENTIFIER, pick any "regular" token type that is not whitespace/newline/indent.
  private val CodeTok: IElementType = UnisonTypes.IDENTIFIER

  override def start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int): Unit = {
    this.buf = buffer
//    this.start = startOffset
    this.end = endOffset
    this.pos = startOffset
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

    val c = buf.charAt(pos)

    // emit paren tokens as their own tokens so IndentingLexer can track depth
    if (c == '(') { tokenType = UnisonTypes.LPAREN; tokenStart = pos; tokenEnd = pos + 1; pos += 1; return }
    if (c == ')') { tokenType = UnisonTypes.RPAREN; tokenStart = pos; tokenEnd = pos + 1; pos += 1; return }

    val isWs = c == ' ' || c == '\t' || c == '\n' || c == '\r'
    val tpe: IElementType = if (isWs) TokenType.WHITE_SPACE else CodeTok

    tokenType = tpe
    tokenStart = pos

    var i = pos
    while (i < end) {
      val ch = buf.charAt(i)
      val ws = ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r'
      if (tpe == TokenType.WHITE_SPACE) {
        if (!ws || ch == '(' || ch == ')') { // stop before parens so they become their own tokens
          i = end + 1 // break using guard below
        } else i += 1
      } else {
        if (ws || ch == '(' || ch == ')') {
          i = end + 1
        } else i += 1
      }
    }

    // the loop ends with i == end+1 when we "broke"
    val nextPos = Math.min(
      end,
      if (i == end + 1) {
        // find the actual stop point
        var j = tokenStart
        while (j < end) {
          val ch = buf.charAt(j)
          val ws = ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r'
          val boundary =
            if (tpe == TokenType.WHITE_SPACE) (!ws || ch == '(' || ch == ')')
            else (ws || ch == '(' || ch == ')')
          if (j != tokenStart && boundary) return { tokenEnd = j; pos = j } // early return
          j += 1
        }
        end
      } else i
    )

    tokenEnd = nextPos
    pos = nextPos
  }
}
