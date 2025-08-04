package intellij.unison.language

import com.intellij.psi.tree.TokenSet
import intellij.unison.language.psi.UnisonTypes

object UnisonTokenSets {
  val IDENTIFIERS: TokenSet = TokenSet.create(UnisonTypes.IDENTIFIER)
  val COMMENTS: TokenSet = TokenSet.create(UnisonTypes.COMMENT)
}
