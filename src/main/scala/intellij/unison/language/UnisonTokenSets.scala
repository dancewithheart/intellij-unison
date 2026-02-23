package intellij.unison.language

import com.intellij.psi.tree.TokenSet
import intellij.unison.language.psi.UnisonTypes

object UnisonTokenSets {
  val IDENTIFIERS: TokenSet = TokenSet.create(UnisonTypes.IDENTIFIER_TOKEN)
  val COMMENTS: TokenSet = TokenSet.create(UnisonTypes.LINE_COMMENT_TOKEN, UnisonTypes.MULTILINE_COMMENT_TOKEN)
}
