package intellij.unison

import com.intellij.lexer.{Lexer, LexerBase}
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.unison.language.psi.UnisonTypes

import java.util.ArrayDeque

object IndentingLexer {
  final case class Tok(tpe: IElementType, start: Int, end: Int)

  final case class State(
      buffer: CharSequence,
      startOffset: Int,
      endOffset: Int,
      atLineStart: Boolean,
      pendingIndent: Option[Int],
      pendingIndentPos: Option[Int],
      pendingDedentAnchor: Option[Int],
      parenDepth: Int
  )

  val emptyState: State =
    State(
      buffer = "",
      startOffset = 0,
      endOffset = 0,
      atLineStart = true,
      pendingIndent = None,
      pendingIndentPos = None,
      pendingDedentAnchor = None,
      parenDepth = 0
    )
}

class IndentingLexer(private val base: Lexer)
    extends LexerBase {
  import intellij.unison.IndentingLexer.{Tok, State, emptyState}

  private val q = new ArrayDeque[Tok]()
  private val indentStack = new ArrayDeque[Int]()

  private var st: State = emptyState

  private var tokenType: IElementType = null
  private var tokenStart: Int = 0
  private var tokenEnd: Int = 0

  override def start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int): Unit = {
    st = emptyState.copy(
      buffer = buffer,
      startOffset = startOffset,
      endOffset = endOffset
    )

    q.clear()
    indentStack.clear()
    indentStack.push(0)

    base.start(buffer, startOffset, endOffset, initialState)
    pullNext()
  }

  override def getState: Int = base.getState
  override def getBufferSequence: CharSequence = st.buffer
  override def getBufferEnd: Int = st.endOffset

  override def getTokenType: IElementType = tokenType
  override def getTokenStart: Int = tokenStart
  override def getTokenEnd: Int = tokenEnd

  override def advance(): Unit = pullNext()

  private def pullNext(): Unit = {
    if (!q.isEmpty) setToken(q.removeFirst())
    else pullFromBase()
  }

  private def pullFromBase(): Unit = {
    val t = base.getTokenType

    if (t == null) { flushDedentsAtEof(); return }

    if (t == TokenType.WHITE_SPACE) {
      splitWhitespace(base.getTokenStart, base.getTokenEnd)
      base.advance()
      pullNext()
      return
    }

    if (st.parenDepth == 0 && st.atLineStart) {
      st.pendingIndent.foreach { ind =>
        emitIndentDedent(ind)
        st = st.copy(pendingIndent = None, atLineStart = false)
      }
      if (!q.isEmpty) { setToken(q.removeFirst()); return }
    }

    val real = Tok(t, base.getTokenStart, base.getTokenEnd)
    st = st.copy(parenDepth = updateParenDepth(st.parenDepth, t))
    base.advance()
    setToken(real)
  }

  private def flushDedentsAtEof(): Unit = {
    if (indentStack.size() > 1) {
      indentStack.pop()
      val p = Math.max(st.startOffset, st.endOffset - 1)
      setToken(Tok(UnisonTypes.DEDENT, p, st.endOffset))
    } else tokenType = null
  }

  private def updateParenDepth(depth: Int, t: IElementType): Int =
    if (t == UnisonTypes.LPAREN || t == UnisonTypes.LPARENSQ || t == UnisonTypes.LBRACE) depth + 1
    else if (t == UnisonTypes.RPAREN || t == UnisonTypes.RPARENSQ || t == UnisonTypes.RBRACE) Math.max(0, depth - 1)
    else depth

  private def splitWhitespace(wsStart: Int, wsEnd: Int): Unit = {
    if (st.parenDepth > 0) {
      q.addLast(Tok(TokenType.WHITE_SPACE, wsStart, wsEnd))
      return
    }

    val buf = st.buffer
    var segStart = wsStart
    var lastNl = -1

    var i = wsStart
    while (i < wsEnd) {
      if (buf.charAt(i) == '\n') {
        if (segStart < i) q.addLast(Tok(TokenType.WHITE_SPACE, segStart, i))
        q.addLast(Tok(UnisonTypes.NEWLINE, i, i + 1))
        st = st.copy(atLineStart = true)
        lastNl = i
        segStart = i + 1
      }
      i += 1
    }

    if (segStart < wsEnd) q.addLast(Tok(TokenType.WHITE_SPACE, segStart, wsEnd))

    if (lastNl >= 0) {
      val tailStart = lastNl + 1
      val indentW = computeIndentWidth(buf, tailStart, wsEnd)
      val indentPos = firstIndentCharPos(buf, tailStart, wsEnd)

      st = st.copy(
        pendingIndent = Some(indentW),
        pendingIndentPos = Some(indentPos),
        pendingDedentAnchor = Some(lastNl)
      )
    }
  }

  private def computeIndentWidth(buf: CharSequence, from: Int, to: Int): Int = {
    var w = 0
    var i = from
    while (i < to) {
      buf.charAt(i) match {
        case ' '  => w += 1
        case '\t' => w += 4
        case _    => return w
      }
      i += 1
    }
    w
  }

  private def firstIndentCharPos(buf: CharSequence, from: Int, to: Int): Int = {
    var i = from
    while (i < to) {
      buf.charAt(i) match {
        case ' ' | '\t'  => return i
        case '\n' | '\r' => // skip
        case _           => return from
      }
      i += 1
    }
    from
  }

  private def emitIndentDedent(newIndent: Int): Unit = {
    val cur = indentStack.peek()

    val indentPos = st.pendingIndentPos.getOrElse(base.getTokenStart)
    val dedentPos = st.pendingDedentAnchor.getOrElse(base.getTokenStart)

    if (newIndent > cur) {
      indentStack.push(newIndent)
      q.addLast(Tok(UnisonTypes.INDENT, indentPos, Math.min(indentPos + 1, st.endOffset)))
    } else if (newIndent < cur) {
      while (indentStack.size() > 1 && indentStack.peek() > newIndent) {
        indentStack.pop()
        q.addLast(Tok(UnisonTypes.DEDENT, dedentPos, Math.min(dedentPos + 1, st.endOffset)))
      }
    }

    st = st.copy(pendingIndentPos = None, pendingDedentAnchor = None)
  }

  private def setToken(t: Tok): Unit = {
    tokenType = t.tpe
    tokenStart = t.start
    tokenEnd = t.end
  }
}
