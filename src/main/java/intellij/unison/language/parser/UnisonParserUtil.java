package intellij.unison.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import intellij.unison.language.psi.UnisonTypes;

public class UnisonParserUtil extends GeneratedParserUtilBase {

    public static boolean missingRhs(PsiBuilder builder, int level) {
        // A declaration ended immediately after '='.
        if (builder.eof() || builder.getTokenType() == UnisonTypes.NEWLINE) {
            builder.error("Expression expected after '='");
            return true;
        }

        return false;
    }
}
