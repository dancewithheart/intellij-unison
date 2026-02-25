package intellij.unison.language.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.{createTextAttributesKey => mkTextAttribKey}
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors => DLHC}
import com.intellij.openapi.editor.{HighlighterColors => HC}
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLexerAdapter
import UnisonSyntaxHighlighter._
import intellij.unison.language.UnisonTokenSets._

case class UnisonSyntaxHighlighter()
    extends SyntaxHighlighterBase {

  override def getHighlightingLexer: Lexer = new UnisonLexerAdapter()

  override def getTokenHighlights(t: IElementType): Array[TextAttributesKey] =
    if (COMMENTS.contains(t)) COMMENT_KEYS
    else if (KEYWORDS.contains(t)) KEYWORD_KEYS
    else if (BUILTIN_TYPES.contains(t)) BUILTIN_KEYS
    else if (LITERALS.contains(t)) LITERAL_KEYS
    else if (PUNCTUATION.contains(t)) PUNCT_KEYS
    else if (IDENTIFIERS.contains(t)) IDENT_KEYS
    else EMPTY_KEYS
}

object UnisonSyntaxHighlighter {
  private def keys(k: TextAttributesKey): Array[TextAttributesKey] = Array(k)

  val IDENT = mkTextAttribKey("UNISON_IDENTIFIER", DLHC.IDENTIFIER)
  val KEYWORD = mkTextAttribKey("UNISON_KEYWORD", DLHC.KEYWORD)
  val BUILTIN = mkTextAttribKey("UNISON_BUILTIN", DLHC.PREDEFINED_SYMBOL)
  val LITERAL = mkTextAttribKey("UNISON_LITERAL", DLHC.NUMBER)
  val PUNCT = mkTextAttribKey("UNISON_PUNCT", DLHC.OPERATION_SIGN)
  val COMMENT = mkTextAttribKey("UNISON_COMMENT", DLHC.LINE_COMMENT)
  val BAD = mkTextAttribKey("UNISON_BAD_CHAR", HC.BAD_CHARACTER)

  val IDENT_KEYS: Array[TextAttributesKey] = keys(IDENT)
  val KEYWORD_KEYS: Array[TextAttributesKey] = keys(KEYWORD)
  val BUILTIN_KEYS: Array[TextAttributesKey] = keys(BUILTIN)
  val LITERAL_KEYS: Array[TextAttributesKey] = keys(LITERAL)
  val PUNCT_KEYS: Array[TextAttributesKey] = keys(PUNCT)
  val COMMENT_KEYS: Array[TextAttributesKey] = keys(COMMENT)
  val BAD_CHAR_KEYS: Array[TextAttributesKey] = keys(BAD)

  val EMPTY_KEYS: Array[TextAttributesKey] = Array.empty
}
