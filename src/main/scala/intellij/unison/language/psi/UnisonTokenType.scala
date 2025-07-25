package intellij.unison.language.psi

import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLanguage

class UnisonTokenType(debugName: String)
    extends IElementType(debugName, UnisonLanguage.INSTANCE) {

  override def toString: String = "UnisonTokenType." + super.toString
}
