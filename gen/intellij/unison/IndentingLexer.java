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

    @Override public int getState() { return 0; }
    @Override public CharSequence getBufferSequence() { return buffer; }
    @Override public int getBufferEnd() { return endOffset; }

    @Override public IElementType getTokenType() { return tokenType; }
    @Override public int getTokenStart() { return tokenStart; }
    @Override public int getTokenEnd() { return tokenEnd; }

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
                setToken(new Tok(UnisonTypes.DEDENT, endOffset, endOffset));
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
            emitIndentDedent(pendingIndent, base.getTokenStart());
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

        int i = wsStart;
        int lastNl = -1;

        while (i < wsEnd) {
            char c = buffer.charAt(i);
            if (c == '\n') {
                // Emit any whitespace before newline (spaces/tabs)
                if (i > wsStart && wsStart > lastNl + 1) {
                    queue.addLast(new Tok(TokenType.WHITE_SPACE, Math.max(wsStart, lastNl + 1), i));
                }
                // Emit NEWLINE token for the '\n' char itself
                queue.addLast(new Tok(UnisonTypes.NEWLINE, i, i + 1));
                atLineStart = true;
                lastNl = i;
            }
            i++;
        }

        // Trailing indentation after the last newline (or all whitespace if no newline).
        int tailStart = (lastNl >= 0) ? lastNl + 1 : wsStart;
        if (tailStart < wsEnd) {
            queue.addLast(new Tok(TokenType.WHITE_SPACE, tailStart, wsEnd));
        }

        // If there was at least one newline, compute indent from trailing spaces/tabs after the last '\n'.
        if (lastNl >= 0) {
            pendingIndent = computeIndentWidth(tailStart, wsEnd);
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

    private void emitIndentDedent(int newIndent, int anchor) {
        int cur = indentStack.peek();
        if (newIndent > cur) {
            indentStack.push(newIndent);
            queue.addLast(new Tok(UnisonTypes.INDENT, anchor, anchor));
        } else if (newIndent < cur) {
            while (indentStack.size() > 1 && indentStack.peek() > newIndent) {
                indentStack.pop();
                queue.addLast(new Tok(UnisonTypes.DEDENT, anchor, anchor));
            }
        }
    }

    private void setToken(Tok t) {
        tokenType = t.type;
        tokenStart = t.start;
        tokenEnd = t.end;
    }
}
