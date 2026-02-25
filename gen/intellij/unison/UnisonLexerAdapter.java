package intellij.unison;

import com.intellij.lexer.FlexAdapter;

public class UnisonLexerAdapter extends IndentingLexer {
    public UnisonLexerAdapter() {
        super(new FlexAdapter(new UnisonLexer(null)));
    }
}
