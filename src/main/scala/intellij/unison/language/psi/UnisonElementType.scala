package intellij.unison.language.psi

import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLanguage

class UnisonElementType(debugName: String)
    extends IElementType(debugName, UnisonLanguage.INSTANCE)
