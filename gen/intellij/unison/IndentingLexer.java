package intellij.unison;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.LexerBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import intellij.unison.language.psi.UnisonTypes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Wraps a base lexer and injects NEWLINE / INDENT / DEDENT tokens based on leading whitespace.
 * NEWLINE/indentation are ignored inside (), [], {}.
 */
public class IndentingLexer extends LexerBase {

    private static final class Tok {
        final IElementType type;
        final int start;
        final int end;
        Tok(IElementType type, int start, int end) { this.type = type; this.start = start; this.end = end; }
    }

    private final Lexer base;

    private CharSequence buffer;
    private int startOffset;
    private int endOffset;

    private final Deque<Tok> queue = new ArrayDeque<>();
    private final Deque<Integer> indentStack = new ArrayDeque<>();

    private boolean atLineStart = true;
    private Integer pendingIndent = null;
    private int parenDepth = 0;

    private IElementType tokenType;
    private int tokenStart;
    private int tokenEnd;

    public IndentingLexer(Lexer base) {
        this.base = base;
    }

    @Override
    public void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
        this.buffer = buffer;
        this.startOffset = startOffset;
        this.endOffset = endOffset;

        queue.clear();
        indentStack.clear();
        indentStack.push(0);

        atLineStart = true;
        pendingIndent = null;
        parenDepth = 0;

        base.start(buffer, startOffset, endOffset, initialState);
        pullNext();
    }

    @Override public int getState() { return base.getState(); }
    @Override public CharSequence getBufferSequence() { return buffer; }
    @Override public int getBufferEnd() { return endOffset; }

    @Override public IElementType getTokenType() { return tokenType; }
    @Override public int getTokenStart() { return tokenStart; }
    @Override public int getTokenEnd() { return tokenEnd; }

    private Integer pendingIndentPos = null;      // first space/tab after newline
    private Integer pendingDedentAnchor = null;   // newline position

    @Override
    public void advance() {
        pullNext();
    }

    private void pullNext() {
        // If we already have queued synthetic/split tokens, serve them first.
        if (!queue.isEmpty()) {
            Tok t = queue.removeFirst();
            setToken(t);
            return;
        }

        IElementType t = base.getTokenType();

        // End of base stream: flush remaining DEDENTs.
        if (t == null) {
            if (indentStack.size() > 1) {
                indentStack.pop();
                int p = Math.max(startOffset, endOffset - 1);
                setToken(new Tok(UnisonTypes.DEDENT, p, endOffset));
            } else {
                tokenType = null;
            }
            return;
        }

        // Handle whitespace (split into WHITE_SPACE + NEWLINE + WHITE_SPACE parts).
        if (t == TokenType.WHITE_SPACE) {
            splitWhitespace(base.getTokenStart(), base.getTokenEnd());
            base.advance();
            pullNext();
            return;
        }

        // Before emitting a real token: if we’re at line start and have computed indent, emit INDENT/DEDENT first.
        if (parenDepth == 0 && atLineStart && pendingIndent != null) {
            emitIndentDedent(pendingIndent);
            pendingIndent = null;
            atLineStart = false;

            if (!queue.isEmpty()) {
                Tok q = queue.removeFirst();
                setToken(q);
                return;
            }
        }

        // Emit the real token.
        int s = base.getTokenStart();
        int e = base.getTokenEnd();
        Tok real = new Tok(t, s, e);

        // Update paren depth based on brackets.
        if (t == UnisonTypes.LPAREN || t == UnisonTypes.LPARENSQ || t == UnisonTypes.LBRACE) parenDepth++;
        else if (t == UnisonTypes.RPAREN || t == UnisonTypes.RPARENSQ || t == UnisonTypes.RBRACE) parenDepth = Math.max(0, parenDepth - 1);

        base.advance();
        setToken(real);
    }

    private void splitWhitespace(int wsStart, int wsEnd) {
        // If inside parens/brackets/braces, ignore NEWLINE semantics; just emit as one WHITE_SPACE token.
        if (parenDepth > 0) {
            queue.addLast(new Tok(TokenType.WHITE_SPACE, wsStart, wsEnd));
            return;
        }

        int segStart = wsStart;
        int lastNl = -1;

        for (int i = wsStart; i < wsEnd; i++) {
            char c = buffer.charAt(i);
            if (c == '\n') {
                // whitespace before newline
                if (segStart < i) {
                    queue.addLast(new Tok(TokenType.WHITE_SPACE, segStart, i));
                }

                // NEWLINE has a real span (i, i+1)
                queue.addLast(new Tok(UnisonTypes.NEWLINE, i, i + 1));
                atLineStart = true;
                lastNl = i;

                segStart = i + 1; // start after '\n'
            }
        }

        // trailing whitespace after last newline (indentation) or whole segment if no newline
        if (segStart < wsEnd) {
            queue.addLast(new Tok(TokenType.WHITE_SPACE, segStart, wsEnd));
        }

        if (lastNl >= 0) {
            int tailStart = lastNl + 1;
            pendingIndent = computeIndentWidth(tailStart, wsEnd);

            // IMPORTANT: remember where indentation begins so INDENT can take a non-zero span
            pendingIndentPos = firstIndentCharPos(tailStart, wsEnd);
            pendingDedentAnchor = lastNl; // use newline char span as DEDENT anchor
        }
    }

    private int computeIndentWidth(int from, int to) {
        int w = 0;
        for (int i = from; i < to; i++) {
            char c = buffer.charAt(i);
            if (c == ' ') w += 1;
            else if (c == '\t') w += 4; // pick a convention; can be configurable later
            else break;
        }
        return w;
    }

    private void emitIndentDedent(int newIndent) {
        int cur = indentStack.peek();

        // Use real spans:
        // - INDENT uses (pendingIndentPos, pendingIndentPos+1) if possible
        // - DEDENT uses (pendingDedentAnchor, pendingDedentAnchor+1) (newline char)
        int indentPos = (pendingIndentPos != null) ? pendingIndentPos : base.getTokenStart();
        int dedentPos = (pendingDedentAnchor != null) ? pendingDedentAnchor : base.getTokenStart();

        if (newIndent > cur) {
            indentStack.push(newIndent);
            queue.addLast(new Tok(UnisonTypes.INDENT, indentPos, Math.min(indentPos + 1, endOffset)));
        } else if (newIndent < cur) {
            while (indentStack.size() > 1 && indentStack.peek() > newIndent) {
                indentStack.pop();
                queue.addLast(new Tok(UnisonTypes.DEDENT, dedentPos, Math.min(dedentPos + 1, endOffset)));
            }
        }

        pendingIndentPos = null;
        pendingDedentAnchor = null;
    }

    private int firstIndentCharPos(int from, int to) {
        for (int i = from; i < to; i++) {
            char c = buffer.charAt(i);
            if (c == ' ' || c == '\t') return i;
            if (c == '\n' || c == '\r') continue;
            break; // hit real code
        }
        return from; // fallback
    }

    private void setToken(Tok t) {
        tokenType = t.type;
        tokenStart = t.start;
        tokenEnd = t.end;
    }
}
