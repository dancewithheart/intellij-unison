package intellij.unison.language

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import intellij.unison.language.psi.UnisonTypes

object UnisonTokenSets {

  // IntelliJ will automatically skip these tokens between grammar elements.
  // IMPORTANT: for significant whitespace, do NOT include NEWLINE/INDENT/DEDENT here.
  val WHITESPACE: TokenSet =
    TokenSet.create(TokenType.WHITE_SPACE)

  val COMMENTS: TokenSet =
    TokenSet.create(UnisonTypes.LINE_COMMENT_TOKEN, UnisonTypes.MULTILINE_COMMENT_TOKEN)

  val IDENTIFIERS: TokenSet =
    TokenSet.create(UnisonTypes.IDENTIFIER_TOKEN, UnisonTypes.OPERATOR_ID_TOKEN)

  val KEYWORDS: TokenSet =
    TokenSet.create(
      UnisonTypes.NAMESPACE,
      UnisonTypes.USE,
      UnisonTypes.ABILITY,
      UnisonTypes.TYPE,
      UnisonTypes.STRUCTURAL,
      UnisonTypes.UNIQUE,
      UnisonTypes.LET,
      UnisonTypes.IF,
      UnisonTypes.THEN,
      UnisonTypes.ELSE,
      UnisonTypes.MATCH,
      UnisonTypes.WITH,
      UnisonTypes.CASES,
      UnisonTypes.CATCH,
      UnisonTypes.OTHERWISE,
      UnisonTypes.WHERE,
      UnisonTypes.FORALL,
      UnisonTypes.DO,
      UnisonTypes.NOT
    )

  val PUNCTUATION: TokenSet =
    TokenSet.create(
      UnisonTypes.ARROW,
      UnisonTypes.COLON,
      UnisonTypes.EQ,
      UnisonTypes.COMMA,
      UnisonTypes.DOT,
      UnisonTypes.BAR,
      UnisonTypes.AT,
      UnisonTypes.LPAREN,
      UnisonTypes.RPAREN,
      UnisonTypes.LBRACE,
      UnisonTypes.RBRACE,
      UnisonTypes.LPARENSQ,
      UnisonTypes.RPARENSQ,
      UnisonTypes.BACKSLASH,
      UnisonTypes.UNDERSCORE
    )

  val LITERALS: TokenSet =
    TokenSet.create(
      UnisonTypes.INT_TOKEN,
      UnisonTypes.DOUBLE_TOKEN,
      UnisonTypes.STRING_TOKEN,
      UnisonTypes.CHAR_TOKEN,
      UnisonTypes.BYTES_TOKEN,
      UnisonTypes.BOOLEAN_TOKEN
    )

  val BUILTIN_TYPES: TokenSet =
    TokenSet.create(
      UnisonTypes.KW_NAT,
      UnisonTypes.KW_INT,
      UnisonTypes.KW_TEXT,
      UnisonTypes.KW_CHAR,
      UnisonTypes.KW_FLOAT,
      UnisonTypes.KW_DOUBLE,
      UnisonTypes.KW_BOOLEAN,
      UnisonTypes.KW_BYTES,
      UnisonTypes.KW_UNIT
    )

  // Used by IntelliJ for string-related features; keep this conservative and correct.
  val STRING_LITERALS: TokenSet =
    TokenSet.create(UnisonTypes.STRING_TOKEN)
}
