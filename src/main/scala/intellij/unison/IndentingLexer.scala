package intellij.unison

import com.intellij.lexer.{Lexer, LexerBase}
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.unison.language.psi.UnisonTypes

import java.util.{ArrayDeque, Deque}

class IndentingLexer(private val base: Lexer) extends LexerBase {

  private final class Tok(val tpe: IElementType, val start: Int, val end: Int)

  private var buffer: CharSequence = ""
  private var startOffset: Int = 0
  private var endOffset: Int = 0

  private val queue: Deque[Tok] = new ArrayDeque[Tok]()
  private val indentStack: Deque[Integer] = new ArrayDeque[Integer]()

  private var atLineStart: Boolean = true
  private var pendingIndent: java.lang.Integer = null
  private var parenDepth: Int = 0

  private var tokenType: IElementType = null
  private var tokenStart: Int = 0
  private var tokenEnd: Int = 0

  private var pendingIndentPos: java.lang.Integer = null      // first space/tab after newline
  private var pendingDedentAnchor: java.lang.Integer = null   // newline position

  override def start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int): Unit = {
    this.buffer = buffer
    this.startOffset = startOffset
    this.endOffset = endOffset

    queue.clear()
    indentStack.clear()
    indentStack.push(0)

    atLineStart = true
    pendingIndent = null
    parenDepth = 0
    pendingIndentPos = null
    pendingDedentAnchor = null

    base.start(buffer, startOffset, endOffset, initialState)
    pullNext()
  }

  override def getState: Int = base.getState
  override def getBufferSequence: CharSequence = buffer
  override def getBufferEnd: Int = endOffset

  override def getTokenType: IElementType = tokenType
  override def getTokenStart: Int = tokenStart
  override def getTokenEnd: Int = tokenEnd

  override def advance(): Unit = pullNext()

  private def pullNext(): Unit = {
    // serve queued synthetic tokens first
    if (!queue.isEmpty) {
      val t = queue.removeFirst()
      setToken(t)
      return
    }

    val t = base.getTokenType

    // end: flush remaining DEDENTs
    if (t == null) {
      if (indentStack.size() > 1) {
        indentStack.pop()
        val p = Math.max(startOffset, endOffset - 1)
        setToken(new Tok(UnisonTypes.DEDENT, p, endOffset))
      } else {
        tokenType = null
      }
      return
    }

    // split whitespace into WHITE_SPACE / NEWLINE / WHITE_SPACE
    if (t == TokenType.WHITE_SPACE) {
      splitWhitespace(base.getTokenStart, base.getTokenEnd)
      base.advance()
      pullNext()
      return
    }

    // emit INDENT/DEDENT before real token if needed
    if (parenDepth == 0 && atLineStart && pendingIndent != null) {
      emitIndentDedent(pendingIndent.intValue())
      pendingIndent = null
      atLineStart = false

      if (!queue.isEmpty) {
        val q = queue.removeFirst()
        setToken(q)
        return
      }
    }

    // emit real token
    val s = base.getTokenStart
    val e = base.getTokenEnd
    val real = new Tok(t, s, e)

    // update paren depth
    if (t == UnisonTypes.LPAREN || t == UnisonTypes.LPARENSQ || t == UnisonTypes.LBRACE) parenDepth += 1
    else if (t == UnisonTypes.RPAREN || t == UnisonTypes.RPARENSQ || t == UnisonTypes.RBRACE) parenDepth = Math.max(0, parenDepth - 1)

    base.advance()
    setToken(real)
  }

  private def splitWhitespace(wsStart: Int, wsEnd: Int): Unit = {
    // ignore NEWLINE semantics inside (), [], {}
    if (parenDepth > 0) {
      queue.addLast(new Tok(TokenType.WHITE_SPACE, wsStart, wsEnd))
      return
    }

    var segStart = wsStart
    var lastNl = -1

    var i = wsStart
    while (i < wsEnd) {
      val c = buffer.charAt(i)
      if (c == '\n') {
        if (segStart < i) queue.addLast(new Tok(TokenType.WHITE_SPACE, segStart, i))
        queue.addLast(new Tok(UnisonTypes.NEWLINE, i, i + 1))
        atLineStart = true
        lastNl = i
        segStart = i + 1
      }
      i += 1
    }

    if (segStart < wsEnd) queue.addLast(new Tok(TokenType.WHITE_SPACE, segStart, wsEnd))

    if (lastNl >= 0) {
      val tailStart = lastNl + 1
      pendingIndent = computeIndentWidth(tailStart, wsEnd)
      pendingIndentPos = firstIndentCharPos(tailStart, wsEnd)
      pendingDedentAnchor = lastNl
    }
  }

  private def computeIndentWidth(from: Int, to: Int): java.lang.Integer = {
    var w = 0
    var i = from
    while (i < to) {
      buffer.charAt(i) match {
        case ' '  => w += 1
        case '\t' => w += 4 // convention
        case _    => i = to // break
      }
      i += 1
    }
    w
  }

  private def emitIndentDedent(newIndent: Int): Unit = {
    val cur = indentStack.peek().intValue()

    val indentPos = if (pendingIndentPos != null) pendingIndentPos.intValue() else base.getTokenStart
    val dedentPos = if (pendingDedentAnchor != null) pendingDedentAnchor.intValue() else base.getTokenStart

    if (newIndent > cur) {
      indentStack.push(newIndent)
      queue.addLast(new Tok(UnisonTypes.INDENT, indentPos, Math.min(indentPos + 1, endOffset)))
    } else if (newIndent < cur) {
      while (indentStack.size() > 1 && indentStack.peek().intValue() > newIndent) {
        indentStack.pop()
        queue.addLast(new Tok(UnisonTypes.DEDENT, dedentPos, Math.min(dedentPos + 1, endOffset)))
      }
    }

    pendingIndentPos = null
    pendingDedentAnchor = null
  }

  private def firstIndentCharPos(from: Int, to: Int): java.lang.Integer = {
    var i = from
    while (i < to) {
      val c = buffer.charAt(i)
      if (c == ' ' || c == '\t') return i
      if (c == '\n' || c == '\r') { i += 1; () }
      else return from
      i += 1
    }
    from
  }

  private def setToken(t: Tok): Unit = {
    tokenType = t.tpe
    tokenStart = t.start
    tokenEnd = t.end
  }
}