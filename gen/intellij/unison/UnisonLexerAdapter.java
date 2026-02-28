package intellij.unison;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;

public final class UnisonLexerAdapter extends IndentingLexer {
    public UnisonLexerAdapter() {
        super(base());
    }

    private static Lexer base() {
        return new FlexAdapter(new UnisonLexer(null));
    }
}
