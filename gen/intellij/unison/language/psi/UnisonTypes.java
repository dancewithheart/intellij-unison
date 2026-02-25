// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.impl.*;

public interface UnisonTypes {

  IElementType ABILITY_DECL = new UnisonElementType("ABILITY_DECL");
  IElementType BINDING = new UnisonElementType("BINDING");
  IElementType BOOLEAN = new UnisonElementType("BOOLEAN");
  IElementType BOOL_EXPR = new UnisonElementType("BOOL_EXPR");
  IElementType BOOL_OPERATOR = new UnisonElementType("BOOL_OPERATOR");
  IElementType BUILTIN_TYPE = new UnisonElementType("BUILTIN_TYPE");
  IElementType BYTES = new UnisonElementType("BYTES");
  IElementType CASES_EXPR = new UnisonElementType("CASES_EXPR");
  IElementType CATCH_EXPR = new UnisonElementType("CATCH_EXPR");
  IElementType CHAR = new UnisonElementType("CHAR");
  IElementType COMPARE_OPERATOR = new UnisonElementType("COMPARE_OPERATOR");
  IElementType DATA_CONSTRUCTOR = new UnisonElementType("DATA_CONSTRUCTOR");
  IElementType DATA_TYPE = new UnisonElementType("DATA_TYPE");
  IElementType DELAYED_TYPE = new UnisonElementType("DELAYED_TYPE");
  IElementType DOUBLE = new UnisonElementType("DOUBLE");
  IElementType EXPRESSION = new UnisonElementType("EXPRESSION");
  IElementType FUNCTION_CALL = new UnisonElementType("FUNCTION_CALL");
  IElementType FUN_BODY = new UnisonElementType("FUN_BODY");
  IElementType GUARD_PATTERN = new UnisonElementType("GUARD_PATTERN");
  IElementType IDENTIFIER = new UnisonElementType("IDENTIFIER");
  IElementType IF_THEN_ELSE_EXPR = new UnisonElementType("IF_THEN_ELSE_EXPR");
  IElementType INT = new UnisonElementType("INT");
  IElementType LAMBDA = new UnisonElementType("LAMBDA");
  IElementType LET_EXPR = new UnisonElementType("LET_EXPR");
  IElementType LITERAL = new UnisonElementType("LITERAL");
  IElementType MATCH_CASE = new UnisonElementType("MATCH_CASE");
  IElementType MATCH_EXPR = new UnisonElementType("MATCH_EXPR");
  IElementType NAMESPACE_DECL = new UnisonElementType("NAMESPACE_DECL");
  IElementType NUM_EXPR = new UnisonElementType("NUM_EXPR");
  IElementType NUM_OPERATOR = new UnisonElementType("NUM_OPERATOR");
  IElementType OPERATOR_ID = new UnisonElementType("OPERATOR_ID");
  IElementType PATTERN = new UnisonElementType("PATTERN");
  IElementType POLYMORPHIC_TYPE = new UnisonElementType("POLYMORPHIC_TYPE");
  IElementType QUALIFIED_NAME = new UnisonElementType("QUALIFIED_NAME");
  IElementType STATEMENT = new UnisonElementType("STATEMENT");
  IElementType STRING = new UnisonElementType("STRING");
  IElementType TYPED_DEF = new UnisonElementType("TYPED_DEF");
  IElementType TYPE_EXPR = new UnisonElementType("TYPE_EXPR");
  IElementType USE_CLAUSE = new UnisonElementType("USE_CLAUSE");

  IElementType ABILITY = new UnisonTokenType("ability");
  IElementType ALIAS = new UnisonTokenType("alias");
  IElementType ARROW = new UnisonTokenType("->");
  IElementType AT = new UnisonTokenType("@");
  IElementType BACKSLASH = new UnisonTokenType("\\\\");
  IElementType BANG = new UnisonTokenType("!");
  IElementType BAR = new UnisonTokenType("|");
  IElementType BOOLEAN_TOKEN = new UnisonTokenType("BOOLEAN_TOKEN");
  IElementType BOOL_OPERATOR_TOKEN = new UnisonTokenType("BOOL_OPERATOR_TOKEN");
  IElementType BYTES_TOKEN = new UnisonTokenType("BYTES_TOKEN");
  IElementType CASES = new UnisonTokenType("cases");
  IElementType CATCH = new UnisonTokenType("catch");
  IElementType CHAR_TOKEN = new UnisonTokenType("CHAR_TOKEN");
  IElementType COLON = new UnisonTokenType(":");
  IElementType COMMA = new UnisonTokenType(",");
  IElementType COMPARE_OPERATOR_TOKEN = new UnisonTokenType("COMPARE_OPERATOR_TOKEN");
  IElementType DO = new UnisonTokenType("do");
  IElementType DOT = new UnisonTokenType(".");
  IElementType DOUBLE_TOKEN = new UnisonTokenType("DOUBLE_TOKEN");
  IElementType ELSE = new UnisonTokenType("else");
  IElementType EQ = new UnisonTokenType("=");
  IElementType FORALL = new UnisonTokenType("forall");
  IElementType FORALLSYMBOL = new UnisonTokenType("∀");
  IElementType HANDLE = new UnisonTokenType("handle");
  IElementType IDENTIFIER_TOKEN = new UnisonTokenType("IDENTIFIER_TOKEN");
  IElementType IF = new UnisonTokenType("if");
  IElementType INT_TOKEN = new UnisonTokenType("INT_TOKEN");
  IElementType KW_BOOLEAN = new UnisonTokenType("Boolean");
  IElementType KW_BYTES = new UnisonTokenType("Bytes");
  IElementType KW_CHAR = new UnisonTokenType("Char");
  IElementType KW_DOUBLE = new UnisonTokenType("Double");
  IElementType KW_FLOAT = new UnisonTokenType("Float");
  IElementType KW_INT = new UnisonTokenType("Int");
  IElementType KW_NAT = new UnisonTokenType("Nat");
  IElementType KW_TEXT = new UnisonTokenType("Text");
  IElementType KW_UNIT = new UnisonTokenType("()");
  IElementType LBRACE = new UnisonTokenType("{");
  IElementType LBRACETICK = new UnisonTokenType("'{");
  IElementType LET = new UnisonTokenType("let");
  IElementType LINE_COMMENT_TOKEN = new UnisonTokenType("LINE_COMMENT_TOKEN");
  IElementType LPAREN = new UnisonTokenType("(");
  IElementType LPARENSQ = new UnisonTokenType("[");
  IElementType MATCH = new UnisonTokenType("match");
  IElementType MODW = new UnisonTokenType("mod");
  IElementType MULTILINE_COMMENT_TOKEN = new UnisonTokenType("MULTILINE_COMMENT_TOKEN");
  IElementType NAMESPACE = new UnisonTokenType("namespace");
  IElementType NOT = new UnisonTokenType("not");
  IElementType NUM_OPERATOR_TOKEN = new UnisonTokenType("NUM_OPERATOR_TOKEN");
  IElementType OPERATOR_ID_TOKEN = new UnisonTokenType("OPERATOR_ID_TOKEN");
  IElementType OTHERWISE = new UnisonTokenType("otherwise");
  IElementType QUALIFIED_IMPORT = new UnisonTokenType("qualified_import");
  IElementType RBRACE = new UnisonTokenType("}");
  IElementType RPAREN = new UnisonTokenType(")");
  IElementType RPARENSQ = new UnisonTokenType("]");
  IElementType STRING_TOKEN = new UnisonTokenType("STRING_TOKEN");
  IElementType STRUCTURAL = new UnisonTokenType("structural");
  IElementType TERMLINK = new UnisonTokenType("termLink");
  IElementType THEN = new UnisonTokenType("then");
  IElementType TICK = new UnisonTokenType("'");
  IElementType TYPE = new UnisonTokenType("type");
  IElementType TYPELINK = new UnisonTokenType("typeLink");
  IElementType UNDERSCORE = new UnisonTokenType("_");
  IElementType UNIQUE = new UnisonTokenType("unique");
  IElementType USE = new UnisonTokenType("use");
  IElementType WHERE = new UnisonTokenType("where");
  IElementType WITH = new UnisonTokenType("with");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ABILITY_DECL) {
        return new UnisonAbilityDeclImpl(node);
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
      else if (type == LITERAL) {
        return new UnisonLiteralImpl(node);
      }
      else if (type == MATCH_CASE) {
        return new UnisonMatchCaseImpl(node);
      }
      else if (type == MATCH_EXPR) {
        return new UnisonMatchExprImpl(node);
      }
      else if (type == NAMESPACE_DECL) {
        return new UnisonNamespaceDeclImpl(node);
      }
      else if (type == NUM_EXPR) {
        return new UnisonNumExprImpl(node);
      }
      else if (type == NUM_OPERATOR) {
        return new UnisonNumOperatorImpl(node);
      }
      else if (type == OPERATOR_ID) {
        return new UnisonOperatorIdImpl(node);
      }
      else if (type == PATTERN) {
        return new UnisonPatternImpl(node);
      }
      else if (type == POLYMORPHIC_TYPE) {
        return new UnisonPolymorphicTypeImpl(node);
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
      else if (type == USE_CLAUSE) {
        return new UnisonUseClauseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
