package intellij.unison.language.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.{
  DefaultLanguageHighlighterColors,
  HighlighterColors
}
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLexerAdapter
import intellij.unison.language.psi.UnisonTypes
import UnisonSyntaxHighlighter._

case class UnisonSyntaxHighlighter() extends SyntaxHighlighterBase {

  override def getHighlightingLexer: Lexer = new UnisonLexerAdapter()

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] =
    tokenType match {
      case UnisonTypes.SEPARATOR => SEPARATOR_KEYS
      case UnisonTypes.KEY => KEY_KEYS
      case UnisonTypes.VALUE => VALUE_KEYS
      case UnisonTypes.COMMENT => COMMENT_KEYS
      // TODO else if (tokenType.equals(UnisonTypes.BAD_CHARACTER)) BAD_CHAR_KEYS
      case _ => EMPTY_KEYS
    }
}

object UnisonSyntaxHighlighter {
  val SEPARATOR: TextAttributesKey = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
  val KEY: TextAttributesKey = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
  val VALUE: TextAttributesKey = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
  val COMMENT: TextAttributesKey = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

  val BAD_CHAR_KEYS: Array[TextAttributesKey] = Array(BAD_CHARACTER)
  val SEPARATOR_KEYS: Array[TextAttributesKey] = Array(SEPARATOR)
  val KEY_KEYS: Array[TextAttributesKey] = Array(KEY)
  val VALUE_KEYS: Array[TextAttributesKey] = Array(VALUE)
  val COMMENT_KEYS: Array[TextAttributesKey] = Array(COMMENT)
  val EMPTY_KEYS: Array[TextAttributesKey] = Array()
}
