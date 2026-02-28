package intellij.unison.language.psi

import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLanguage

// Token types correspond to lexer tokens (leaf nodes). The prefixed toString makes
// debug output stable and searchable in logs / golden dumps.
final class UnisonTokenType(debugName: String)
    extends IElementType(debugName, UnisonLanguage.INSTANCE) {

  override def toString: String = "UnisonTokenType." + super.toString
}
