// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.impl.*;

public interface UnisonTypes {

  IElementType ABILITY = new UnisonTokenType("ABILITY");
  IElementType ABILITY_CONSTRUCTOR = new UnisonElementType("ABILITY_CONSTRUCTOR");
  IElementType ABILITY_DECL = new UnisonElementType("ABILITY_DECL");
  IElementType ABILITY_REQUIREMENTS = new UnisonElementType("ABILITY_REQUIREMENTS");
  IElementType ALIAS = new UnisonTokenType("ALIAS");
  IElementType ARGUMENT_LIST = new UnisonElementType("ARGUMENT_LIST");
  IElementType ARROW = new UnisonTokenType("ARROW");
  IElementType AT = new UnisonTokenType("AT");
  IElementType BAR = new UnisonTokenType("BAR");
  IElementType BANG = new UnisonTokenType("BANG");
  IElementType BINDING = new UnisonElementType("BINDING");
  IElementType BOOLEAN = new UnisonElementType("BOOLEAN");
  IElementType BOOL_EXPR = new UnisonElementType("BOOL_EXPR");
  IElementType BOOL_OPERATOR = new UnisonElementType("BOOL_OPERATOR");
  IElementType BUILTIN_TYPE = new UnisonElementType("BUILTIN_TYPE");
  IElementType BYTES = new UnisonElementType("BYTES");
  IElementType CASES = new UnisonTokenType("CASES");
  IElementType CATCH = new UnisonTokenType("CATCH");
  IElementType CASES_EXPR = new UnisonElementType("CASES_EXPR");
  IElementType CATCH_EXPR = new UnisonElementType("CATCH_EXPR");
  IElementType CHAR = new UnisonElementType("CHAR");
  IElementType CIAPEK = new UnisonTokenType("CIAPEK");
  IElementType COMMA = new UnisonTokenType("COMMA");
  IElementType COLON = new UnisonTokenType("COLON");
  IElementType COMPARE_OPERATOR = new UnisonElementType("COMPARE_OPERATOR");
  IElementType CONSTRUCTOR_PATTERN = new UnisonElementType("CONSTRUCTOR_PATTERN");
  IElementType DATA_CONSTRUCTOR = new UnisonElementType("DATA_CONSTRUCTOR");
  IElementType DATA_TYPE = new UnisonElementType("DATA_TYPE");
  IElementType DELAYED_TYPE = new UnisonElementType("DELAYED_TYPE");
  IElementType DO = new UnisonTokenType("DO");
  IElementType DOT = new UnisonTokenType("DOT");
  IElementType DOUBLE = new UnisonElementType("DOUBLE");
  IElementType ELSE = new UnisonTokenType("ELSE");
  IElementType EMPTYBRACES = new UnisonElementType("()");
  IElementType EQ = new UnisonTokenType("EQ");
  IElementType EXPRESSION = new UnisonElementType("EXPRESSION");
  IElementType FLOAT = new UnisonElementType("FLOAT");
  IElementType FORALL = new UnisonElementType("FORALL");
  IElementType FORALLSYMBOL = new UnisonTokenType("FORALLSYMBOL");
  IElementType FUNCTION_CALL = new UnisonElementType("FUNCTION_CALL");
  IElementType FUN_BODY = new UnisonElementType("FUN_BODY");
  IElementType GUARD_PATTERN = new UnisonElementType("GUARD_PATTERN");
  IElementType HANDLE = new UnisonElementType("HANDLE");
  IElementType IDENTIFIER = new UnisonElementType("IDENTIFIER");
  IElementType IF = new UnisonTokenType("IF");
  IElementType IF_THEN_ELSE_EXPR = new UnisonElementType("IF_THEN_ELSE_EXPR");
  IElementType INT = new UnisonElementType("INT");
  IElementType LAMBDA = new UnisonElementType("LAMBDA");
  IElementType LBRACE = new UnisonTokenType("LBRACE");
  IElementType LBRACECIAPEK = new UnisonTokenType("LBRACECIAPEK");
  IElementType LET = new UnisonTokenType("LET");
  IElementType LET_EXPR = new UnisonElementType("LET_EXPR");
  IElementType LINE_COMMENT = new UnisonElementType("LINE_COMMENT");
  IElementType LITERAL = new UnisonElementType("LITERAL");
  IElementType LPAREN = new UnisonTokenType("LPAREN");
  IElementType LPARENSQ = new UnisonTokenType("LPARENSQ");
  IElementType MATCH = new UnisonElementType("MATCH");
  IElementType MATCH_CASE = new UnisonElementType("MATCH_CASE");
  IElementType MATCH_EXPR = new UnisonElementType("MATCH_EXPR");
  IElementType MULTILINE_COMMENT = new UnisonElementType("MULTILINE_COMMENT");
  IElementType MODW = new UnisonTokenType("MODW");
  IElementType NAMESPACE = new UnisonElementType("NAMESPACE");
  IElementType NAMESPACE_DECL = new UnisonElementType("NAMESPACE_DECL");
  IElementType NAT = new UnisonElementType("NAT");
  IElementType NUM_EXPR = new UnisonElementType("NUM_EXPR");
  IElementType NUM_LITERAL = new UnisonElementType("NUM_LITERAL");
  IElementType NUM_OPERATOR = new UnisonElementType("NUM_OPERATOR");
  IElementType NOT = new UnisonTokenType("NOT");
  IElementType OTHERWISE = new UnisonTokenType("OTHERWISE");
  IElementType PATTERN = new UnisonElementType("PATTERN");
  IElementType POLYMORPHIC_TYPE = new UnisonElementType("POLYMORPHIC_TYPE");
  IElementType QUALIFIED_IMPORT = new UnisonElementType("QUALIFIED_IMPORT");
  IElementType QUALIFIED_NAME = new UnisonElementType("QUALIFIED_NAME");
  IElementType RBRACE = new UnisonTokenType("RBRACE");
  IElementType RPAREN = new UnisonTokenType("RPAREN");
  IElementType RPARENSQ = new UnisonTokenType("RPARENSQ");
  IElementType STATEMENT = new UnisonElementType("STATEMENT");
  IElementType STRING = new UnisonElementType("STRING");
  IElementType STRUCTURAL = new UnisonTokenType("STRUCTURAL");
  IElementType THEN = new UnisonTokenType("THEN");
  IElementType TYPED_DEF = new UnisonElementType("TYPED_DEF");
  IElementType TEXT = new UnisonTokenType("TEXT");
  IElementType TYPE = new UnisonTokenType("TYPE");
  IElementType TYPE_EXPR = new UnisonElementType("TYPE_EXPR");
  IElementType TYPE_PARAMS = new UnisonElementType("TYPE_PARAMS");
  IElementType TYPELINK = new UnisonElementType("TYPELINK");
  IElementType TERMLINK = new UnisonElementType("TERMLINK");
  IElementType UNDERSCORE = new UnisonTokenType("UNDERSCORE");
  IElementType WHERE = new UnisonTokenType("WHERE");
  IElementType USE = new UnisonTokenType("USE");
  IElementType USE_CLAUSE = new UnisonElementType("USE_CLAUSE");
  IElementType UNIQUE = new UnisonTokenType("UNIQUE");
  IElementType WITH = new UnisonTokenType("WITH");

  IElementType BOOLEAN_TOKEN = new UnisonTokenType("BOOLEAN_TOKEN");
  IElementType BOOL_OPERATOR_TOKEN = new UnisonTokenType("BOOL_OPERATOR_TOKEN");
  IElementType BYTES_TOKEN = new UnisonTokenType("BYTES_TOKEN");
  IElementType CHAR_TOKEN = new UnisonTokenType("CHAR_TOKEN");
  IElementType COMPARE_OPERATOR_TOKEN = new UnisonTokenType("COMPARE_OPERATOR_TOKEN");
  IElementType DOUBLE_TOKEN = new UnisonTokenType("DOUBLE_TOKEN");
  IElementType FLOAT_TOKEN = new UnisonTokenType("FLOAT_TOKEN");
  IElementType IDENTIFIER_TOKEN = new UnisonTokenType("IDENTIFIER_TOKEN");
  IElementType INT_TOKEN = new UnisonTokenType("INT_TOKEN");
  IElementType LINE_COMMENT_TOKEN = new UnisonTokenType("LINE_COMMENT_TOKEN");
  IElementType MULTILINE_COMMENT_TOKEN = new UnisonTokenType("MULTILINE_COMMENT_TOKEN");
  IElementType NAT_TOKEN = new UnisonTokenType("NAT_TOKEN");
  IElementType NUM_OPERATOR_TOKEN = new UnisonTokenType("NUM_OPERATOR_TOKEN");
  IElementType STRING_TOKEN = new UnisonTokenType("STRING_TOKEN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ABILITY_CONSTRUCTOR) {
        return new UnisonAbilityConstructorImpl(node);
      }
      else if (type == ABILITY_DECL) {
        return new UnisonAbilityDeclImpl(node);
      }
      else if (type == ABILITY_REQUIREMENTS) {
        return new UnisonAbilityRequirementsImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new UnisonArgumentListImpl(node);
      }
      else if (type == BINDING) {
        return new UnisonBindingImpl(node);
      }
      else if (type == BOOLEAN) {
        return new UnisonBooleanImpl(node);
      }
      else if (type == BOOL_EXPR) {
        return new UnisonBoolExprImpl(node);
      }
      else if (type == BOOL_OPERATOR) {
        return new UnisonBoolOperatorImpl(node);
      }
      else if (type == BUILTIN_TYPE) {
        return new UnisonBuiltinTypeImpl(node);
      }
      else if (type == BYTES) {
        return new UnisonBytesImpl(node);
      }
      else if (type == CASES_EXPR) {
        return new UnisonCasesExprImpl(node);
      }
      else if (type == CATCH_EXPR) {
        return new UnisonCatchExprImpl(node);
      }
      else if (type == CHAR) {
        return new UnisonCharImpl(node);
      }
      else if (type == COMPARE_OPERATOR) {
        return new UnisonCompareOperatorImpl(node);
      }
      else if (type == CONSTRUCTOR_PATTERN) {
        return new UnisonConstructorPatternImpl(node);
      }
      else if (type == DATA_CONSTRUCTOR) {
        return new UnisonDataConstructorImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new UnisonDataTypeImpl(node);
      }
      else if (type == DELAYED_TYPE) {
        return new UnisonDelayedTypeImpl(node);
      }
      else if (type == DOUBLE) {
        return new UnisonDoubleImpl(node);
      }
      else if (type == EXPRESSION) {
        return new UnisonExpressionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new UnisonFunctionCallImpl(node);
      }
      else if (type == FUN_BODY) {
        return new UnisonFunBodyImpl(node);
      }
      else if (type == GUARD_PATTERN) {
        return new UnisonGuardPatternImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new UnisonIdentifierImpl(node);
      }
      else if (type == IF_THEN_ELSE_EXPR) {
        return new UnisonIfThenElseExprImpl(node);
      }
      else if (type == INT) {
        return new UnisonIntImpl(node);
      }
      else if (type == LAMBDA) {
        return new UnisonLambdaImpl(node);
      }
      else if (type == LET_EXPR) {
        return new UnisonLetExprImpl(node);
      }
      else if (type == LINE_COMMENT) {
        return new UnisonLineCommentImpl(node);
      }
      else if (type == LITERAL) {
        return new UnisonLiteralImpl(node);
      }
      else if (type == MATCH_CASE) {
        return new UnisonMatchCaseImpl(node);
      }
      else if (type == MATCH_EXPR) {
        return new UnisonMatchExprImpl(node);
      }
      else if (type == MULTILINE_COMMENT) {
        return new UnisonMultilineCommentImpl(node);
      }
      else if (type == NAMESPACE_DECL) {
        return new UnisonNamespaceDeclImpl(node);
      }
      else if (type == NUM_EXPR) {
        return new UnisonNumExprImpl(node);
      }
      else if (type == NUM_LITERAL) {
        return new UnisonNumLiteralImpl(node);
      }
      else if (type == NUM_OPERATOR) {
        return new UnisonNumOperatorImpl(node);
      }
      else if (type == PATTERN) {
        return new UnisonPatternImpl(node);
      }
      else if (type == POLYMORPHIC_TYPE) {
        return new UnisonPolymorphicTypeImpl(node);
      }
      else if (type == QUALIFIED_IMPORT) {
        return new UnisonQualifiedImportImpl(node);
      }
      else if (type == QUALIFIED_NAME) {
        return new UnisonQualifiedNameImpl(node);
      }
      else if (type == STATEMENT) {
        return new UnisonStatementImpl(node);
      }
      else if (type == STRING) {
        return new UnisonStringImpl(node);
      }
      else if (type == TYPED_DEF) {
        return new UnisonTypedDefImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new UnisonTypeExprImpl(node);
      }
      else if (type == TYPE_PARAMS) {
        return new UnisonTypeParamsImpl(node);
      }
      else if (type == USE_CLAUSE) {
        return new UnisonUseClauseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
