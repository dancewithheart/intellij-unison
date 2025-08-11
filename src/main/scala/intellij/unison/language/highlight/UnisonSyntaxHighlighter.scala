package intellij.unison.language.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.{createTextAttributesKey => mkTextAttribKey}
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors => DLHC}
import com.intellij.openapi.editor.{HighlighterColors => HC}
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import intellij.unison.UnisonLexerAdapter
import intellij.unison.language.psi.UnisonTypes
import UnisonSyntaxHighlighter._

case class UnisonSyntaxHighlighter()
    extends SyntaxHighlighterBase {

  override def getHighlightingLexer: Lexer = new UnisonLexerAdapter()

  override def getTokenHighlights(
      tokenType: IElementType
  ): Array[TextAttributesKey] =
    tokenType match {
//      case UnisonTypes.SEPARATOR  => SEPARATOR_KEYS
      case UnisonTypes.IDENTIFIER => IDENTIFIER_KEYS
      case UnisonTypes.TYPE       => TYPE_KEYS
      case UnisonTypes.STRUCTURAL => STRUCTURAL_KEYS
      case UnisonTypes.NAMESPACE  => NAMESPACE_KEYS

      case UnisonTypes.CHAR    => CHAR_KEYS
      case UnisonTypes.BYTES   => BYTES_KEYS
      case UnisonTypes.STRING  => STRING_KEYS
      case UnisonTypes.INT     => INT_KEYS
      case UnisonTypes.NAT     => NAT_KEYS
      case UnisonTypes.DOUBLE  => DOUBLE_KEYS
      case UnisonTypes.FLOAT   => FLOAT_KEYS
      case UnisonTypes.BOOLEAN => BOOLEAN_KEYS
      case UnisonTypes.TEXT    => TEXT_KEYS

      case UnisonTypes.ARROW => ARROW_KEYS
      case UnisonTypes.STAR  => STAR_KEYS
      case UnisonTypes.COMMA => COMMA_KEYS

      case UnisonTypes.LBRACE     => LBRACE_KEYS
      case UnisonTypes.RBRACE     => RBRACE_KEYS
      case UnisonTypes.LPAREN     => LPAREN_KEYS
      case UnisonTypes.RPAREN     => RPAREN_KEYS
      case UnisonTypes.PLUS       => PLUS_KEYS
      case UnisonTypes.MINUS      => MINUS_KEYS
      case UnisonTypes.DIV        => DIV_KEYS
      case UnisonTypes.MODS        => MODS_KEYS
      case UnisonTypes.MODW        => MODW_KEYS
      case UnisonTypes.DOT        => DOT_KEYS
      case UnisonTypes.NOT        => NOT_KEYS
      case UnisonTypes.UNDERSCORE => UNDERSCORE_KEYS
      case UnisonTypes.AT         => AT_KEYS
      case UnisonTypes.LT         => LT_KEYS
      case UnisonTypes.GT         => GT_KEYS
      case UnisonTypes.EQ         => EQ_KEYS
      case UnisonTypes.EQ3        => EQ3_KEYS
      case UnisonTypes.BAR        => BAR_KEYS
      case UnisonTypes.LAMBDA     => LAMBDA_KEYS

      case UnisonTypes.ABILITY => ABILITY_KEYS
      case UnisonTypes.LET     => LET_KEYS

      case UnisonTypes.IF     => IF_KEYS
      case UnisonTypes.THEN   => THEN_KEYS
      case UnisonTypes.ELSE   => ELSE_KEYS
      case UnisonTypes.DO     => DO_KEYS
      case UnisonTypes.UNIQUE => UNIQUE_KEYS

      case UnisonTypes.MATCH => MATCH_KEYS
      case UnisonTypes.CASES => CASES_KEYS
      case UnisonTypes.WITH  => WITH_KEYS
      case UnisonTypes.USE   => USE_KEYS

      case UnisonTypes.COMMENT => COMMENT_KEYS
      // else if (tokenType.equals(UnisonTypes.BAD_CHARACTER)) BAD_CHAR_KEYS
      case _ => EMPTY_KEYS
    }
}

object UnisonSyntaxHighlighter {
  val SEPARATOR: TextAttributesKey = mkTextAttribKey("UNISON_SEPARATOR", DLHC.OPERATION_SIGN)
  val IDENTIFIER: TextAttributesKey = mkTextAttribKey("UNISON_KEY", DLHC.IDENTIFIER)
  val TYPE: TextAttributesKey = mkTextAttribKey("UNISON_TYPE", DLHC.KEYWORD)
  val STRUCTURAL: TextAttributesKey = mkTextAttribKey("UNISON_STRUCTURAL", DLHC.KEYWORD)
  val DO: TextAttributesKey = mkTextAttribKey("UNISON_DO", DLHC.KEYWORD)
  val UNIQUE: TextAttributesKey = mkTextAttribKey("UNISON_UNIQUE", DLHC.KEYWORD)

  val TEXT: TextAttributesKey = mkTextAttribKey("UNISON_TEXT", DLHC.NUMBER)
  val CHAR: TextAttributesKey = mkTextAttribKey("UNISON_CHAR", DLHC.NUMBER)
  val BYTES: TextAttributesKey = mkTextAttribKey("UNISON_BYTES", DLHC.NUMBER)
  val INT: TextAttributesKey = mkTextAttribKey("UNISON_INT", DLHC.NUMBER)
  val NAT: TextAttributesKey = mkTextAttribKey("UNISON_NAT", DLHC.NUMBER)
  val DOUBLE: TextAttributesKey = mkTextAttribKey("UNISON_DOUBLE", DLHC.NUMBER)
  val FLOAT: TextAttributesKey = mkTextAttribKey("UNISON_FLOAT", DLHC.NUMBER)
  val BOOLEAN: TextAttributesKey = mkTextAttribKey("UNISON_BOOLEAN", DLHC.NUMBER) // TODO PP change to boolish color

  val ARROW: TextAttributesKey = mkTextAttribKey("UNISON_ARROW", DLHC.OPERATION_SIGN)
  val STAR: TextAttributesKey = mkTextAttribKey("UNISON_STAR", DLHC.OPERATION_SIGN)
  val AT: TextAttributesKey = mkTextAttribKey("UNISON_AT", DLHC.OPERATION_SIGN)
  val LT: TextAttributesKey = mkTextAttribKey("UNISON_LT", DLHC.OPERATION_SIGN)
  val GT: TextAttributesKey = mkTextAttribKey("UNISON_GT", DLHC.OPERATION_SIGN)
  val EQ: TextAttributesKey = mkTextAttribKey("UNISON_EQ", DLHC.OPERATION_SIGN)
  val EQ3: TextAttributesKey = mkTextAttribKey("UNISON_EQ", DLHC.OPERATION_SIGN)
  val BAR: TextAttributesKey = mkTextAttribKey("UNISON_BAR", DLHC.OPERATION_SIGN)
  val COMMA: TextAttributesKey = mkTextAttribKey("UNISON_COMMA", DLHC.OPERATION_SIGN)
  val UNDERSCORE: TextAttributesKey = mkTextAttribKey("UNISON_UNDERSCORE", DLHC.OPERATION_SIGN)
  val LAMBDA: TextAttributesKey = mkTextAttribKey("UNISON_LAMBDA", DLHC.OPERATION_SIGN)
  val DOT: TextAttributesKey = mkTextAttribKey("UNISON_DOT", DLHC.DOT)

  val PLUS: TextAttributesKey = mkTextAttribKey("UNISON_PLUS", DLHC.OPERATION_SIGN)
  val MINUS: TextAttributesKey = mkTextAttribKey("UNISON_MINUS", DLHC.OPERATION_SIGN)
  val MODS: TextAttributesKey = mkTextAttribKey("UNISON_MOD", DLHC.OPERATION_SIGN)
  val MODW: TextAttributesKey = mkTextAttribKey("UNISON_MOD", DLHC.OPERATION_SIGN)
  val DIV: TextAttributesKey = mkTextAttribKey("UNISON_DIV", DLHC.OPERATION_SIGN)
  val LBRACE: TextAttributesKey = mkTextAttribKey("UNISON_LBRACE", DLHC.BRACES)
  val RBRACE: TextAttributesKey = mkTextAttribKey("UNISON_RBRACE", DLHC.BRACES)
  val LPAREN: TextAttributesKey = mkTextAttribKey("UNISON_LPAREN", DLHC.PARENTHESES)
  val RPAREN: TextAttributesKey = mkTextAttribKey("UNISON_RPAREN", DLHC.PARENTHESES)

  val NAMESPACE: TextAttributesKey = mkTextAttribKey("UNISON_NAMESPACE", DLHC.KEYWORD)
  val USE: TextAttributesKey = mkTextAttribKey("UNISON_USE", DLHC.KEYWORD)
  val NOT: TextAttributesKey = mkTextAttribKey("UNISON_NOT", DLHC.KEYWORD)
  val LET: TextAttributesKey = mkTextAttribKey("UNISON_LET", DLHC.KEYWORD)
  val IF: TextAttributesKey = mkTextAttribKey("UNISON_IF", DLHC.KEYWORD)
  val THEN: TextAttributesKey = mkTextAttribKey("UNISON_THEN", DLHC.KEYWORD)
  val ELSE: TextAttributesKey = mkTextAttribKey("UNISON_ELSE", DLHC.KEYWORD)
  val MATCH: TextAttributesKey = mkTextAttribKey("UNISON_MATCH", DLHC.KEYWORD)
  val CASES: TextAttributesKey = mkTextAttribKey("UNISON_CASES", DLHC.KEYWORD)
  val WITH: TextAttributesKey = mkTextAttribKey("UNISON_WITH", DLHC.KEYWORD)
  val ABILITY: TextAttributesKey = mkTextAttribKey("UNISON_ABILITY", DLHC.KEYWORD)

  val COMMENT: TextAttributesKey = mkTextAttribKey("UNISON_COMMENT", DLHC.LINE_COMMENT)
  val BAD_CHARACTER: TextAttributesKey = mkTextAttribKey("UNISON_BAD_CHARACTER", HC.BAD_CHARACTER)

  val BAD_CHAR_KEYS: Array[TextAttributesKey] = Array(BAD_CHARACTER)
  val SEPARATOR_KEYS: Array[TextAttributesKey] = Array(SEPARATOR)
  val IDENTIFIER_KEYS: Array[TextAttributesKey] = Array(IDENTIFIER)
  val TYPE_KEYS: Array[TextAttributesKey] = Array(TYPE)
  val STRUCTURAL_KEYS: Array[TextAttributesKey] = Array(STRUCTURAL)
  val NAMESPACE_KEYS: Array[TextAttributesKey] = Array(NAMESPACE)
  val USE_KEYS: Array[TextAttributesKey] = Array(USE)
  val STAR_KEYS: Array[TextAttributesKey] = Array(STAR)
  val COMMA_KEYS: Array[TextAttributesKey] = Array(COMMA)

  val LBRACE_KEYS: Array[TextAttributesKey] = Array(LBRACE)
  val RBRACE_KEYS: Array[TextAttributesKey] = Array(RBRACE)
  val LPAREN_KEYS: Array[TextAttributesKey] = Array(LPAREN)
  val RPAREN_KEYS: Array[TextAttributesKey] = Array(RPAREN)
  val DOT_KEYS: Array[TextAttributesKey] = Array(DOT)
  val NOT_KEYS: Array[TextAttributesKey] = Array(NOT)
  val PLUS_KEYS: Array[TextAttributesKey] = Array(PLUS)
  val MINUS_KEYS: Array[TextAttributesKey] = Array(MINUS)
  val MODS_KEYS: Array[TextAttributesKey] = Array(MODS)
  val MODW_KEYS: Array[TextAttributesKey] = Array(MODW)
  val DIV_KEYS: Array[TextAttributesKey] = Array(DIV)
  val UNDERSCORE_KEYS: Array[TextAttributesKey] = Array(UNDERSCORE)
  val LAMBDA_KEYS: Array[TextAttributesKey] = Array(LAMBDA)
  val LT_KEYS: Array[TextAttributesKey] = Array(LT)
  val GT_KEYS: Array[TextAttributesKey] = Array(GT)
  val AT_KEYS: Array[TextAttributesKey] = Array(AT)
  val EQ_KEYS: Array[TextAttributesKey] = Array(EQ)
  val EQ3_KEYS: Array[TextAttributesKey] = Array(EQ3)
  val BAR_KEYS: Array[TextAttributesKey] = Array(BAR)

  val STRING_KEYS: Array[TextAttributesKey] = Array(TEXT)
  val BOOLEAN_KEYS: Array[TextAttributesKey] = Array(BOOLEAN)
  val INT_KEYS: Array[TextAttributesKey] = Array(INT)
  val NAT_KEYS: Array[TextAttributesKey] = Array(NAT)
  val DOUBLE_KEYS: Array[TextAttributesKey] = Array(DOUBLE)
  val FLOAT_KEYS: Array[TextAttributesKey] = Array(FLOAT)
  val BYTES_KEYS: Array[TextAttributesKey] = Array(BYTES)
  val CHAR_KEYS: Array[TextAttributesKey] = Array(CHAR)
  val TEXT_KEYS: Array[TextAttributesKey] = Array(TEXT)

  val ARROW_KEYS: Array[TextAttributesKey] = Array(ARROW)
  val LET_KEYS: Array[TextAttributesKey] = Array(LET)
  val ABILITY_KEYS: Array[TextAttributesKey] = Array(ABILITY)
  val MATCH_KEYS: Array[TextAttributesKey] = Array(MATCH)
  val CASES_KEYS: Array[TextAttributesKey] = Array(CASES)
  val WITH_KEYS: Array[TextAttributesKey] = Array(WITH)
  val IF_KEYS: Array[TextAttributesKey] = Array(IF)
  val THEN_KEYS: Array[TextAttributesKey] = Array(THEN)
  val ELSE_KEYS: Array[TextAttributesKey] = Array(ELSE)
  val DO_KEYS: Array[TextAttributesKey] = Array(DO)
  val UNIQUE_KEYS: Array[TextAttributesKey] = Array(UNIQUE)

  val COMMENT_KEYS: Array[TextAttributesKey] = Array(COMMENT)
  val EMPTY_KEYS: Array[TextAttributesKey] = Array()
}
