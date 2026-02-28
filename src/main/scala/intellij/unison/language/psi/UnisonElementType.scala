package intellij.unison.language.psi

import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLanguage

// PSI element types are used for non-leaf AST nodes produced by the parser (BNF rules).
final class UnisonElementType(debugName: String)
    extends IElementType(debugName, UnisonLanguage.INSTANCE)
