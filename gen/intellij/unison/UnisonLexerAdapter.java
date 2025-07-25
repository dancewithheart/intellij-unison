package intellij.unison;

import com.intellij.lexer.FlexAdapter;

public class UnisonLexerAdapter extends FlexAdapter {

    public UnisonLexerAdapter() {
        super(new UnisonLexer(null));
    }
}
