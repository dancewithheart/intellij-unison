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
  IElementType ARGUMENT_LIST = new UnisonElementType("ARGUMENT_LIST");
  IElementType ARROW = new UnisonTokenType("ARROW");
  IElementType BAR = new UnisonTokenType("BAR");
  IElementType BOOLEAN = new UnisonElementType("BOOLEAN");
  IElementType COMMA = new UnisonTokenType("COMMA");
  IElementType COLON = new UnisonTokenType("COLON");
  IElementType CONSTRUCTOR = new UnisonElementType("CONSTRUCTOR");
  IElementType CONSTRUCTOR_PATTERN = new UnisonElementType("CONSTRUCTOR_PATTERN");
  IElementType DEFINITION = new UnisonElementType("DEFINITION");
  IElementType DOT = new UnisonTokenType("DOT");
  IElementType ELSE = new UnisonTokenType("ELSE");
  IElementType EXPRESSION = new UnisonElementType("EXPRESSION");
  IElementType EQ = new UnisonTokenType("EQ");
  IElementType FUNCTION_CALL = new UnisonElementType("FUNCTION_CALL");
  IElementType IDENTIFIER = new UnisonElementType("IDENTIFIER");
  IElementType IF = new UnisonTokenType("IF");
  IElementType IF_EXPR = new UnisonElementType("IF_EXPR");
  IElementType LAMBDA = new UnisonElementType("LAMBDA");
  IElementType LBRACE = new UnisonTokenType("LBRACE");
  IElementType LET = new UnisonTokenType("LET");
  IElementType LITERAL = new UnisonElementType("LITERAL");
  IElementType LPAREN = new UnisonTokenType("LPAREN");
  IElementType MATCH = new UnisonElementType("MATCH");
  IElementType MATCH_CASE = new UnisonElementType("MATCH_CASE");
  IElementType MATCH_EXPR = new UnisonElementType("MATCH_EXPR");
  IElementType NAMESPACE = new UnisonElementType("NAMESPACE");
  IElementType NAMESPACE_DECL = new UnisonElementType("NAMESPACE_DECL");
  IElementType NUMBER = new UnisonElementType("NUMBER");
  IElementType PATTERN = new UnisonElementType("PATTERN");
  IElementType QUALIFIED_NAME = new UnisonElementType("QUALIFIED_NAME");
  IElementType RBRACE = new UnisonTokenType("RBRACE");
  IElementType RPAREN = new UnisonTokenType("RPAREN");
  IElementType STATEMENT = new UnisonElementType("STATEMENT");
  IElementType STAR = new UnisonTokenType("STAR");
  IElementType STRING = new UnisonElementType("STRING");
  IElementType STRUCTURAL = new UnisonTokenType("STRUCTURAL");
  IElementType THEN = new UnisonTokenType("THEN");
  IElementType TOP_LEVEL_DEFINITION = new UnisonElementType("TOP_LEVEL_DEFINITION");
  IElementType TYPE = new UnisonTokenType("TYPE");
  IElementType TYPE_DECL = new UnisonElementType("TYPE_DECL");
  IElementType TYPE_EXPR = new UnisonElementType("TYPE_EXPR");
  IElementType TYPE_PARAMS = new UnisonElementType("TYPE_PARAMS");
  IElementType UNDERSCORE = new UnisonTokenType("UNDERSCORE");
  IElementType WHERE = new UnisonTokenType("WHERE");
  IElementType USE = new UnisonTokenType("USE");
  IElementType USE_IMPORT = new UnisonElementType("USE_IMPORT");
  IElementType UNIQUE = new UnisonTokenType("UNIQUE");
  IElementType WITH = new UnisonTokenType("WITH");

  IElementType COMMENT = new UnisonTokenType("COMMENT");
  IElementType IDENTIFIER_TOKEN = new UnisonTokenType("IDENTIFIER_TOKEN");
  IElementType NUMBER_TOKEN = new UnisonTokenType("NUMBER_TOKEN");
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
      else if (type == ARGUMENT_LIST) {
        return new UnisonArgumentListImpl(node);
      }
      else if (type == BOOLEAN) {
        return new UnisonBooleanImpl(node);
      }
      else if (type == CONSTRUCTOR) {
        return new UnisonConstructorImpl(node);
      }
      else if (type == CONSTRUCTOR_PATTERN) {
        return new UnisonConstructorPatternImpl(node);
      }
      else if (type == DEFINITION) {
        return new UnisonDefinitionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new UnisonExpressionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new UnisonFunctionCallImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new UnisonIdentifierImpl(node);
      }
      else if (type == IF_EXPR) {
        return new UnisonIfExprImpl(node);
      }
      else if (type == LAMBDA) {
        return new UnisonLambdaImpl(node);
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
      else if (type == NUMBER) {
        return new UnisonNumberImpl(node);
      }
      else if (type == PATTERN) {
        return new UnisonPatternImpl(node);
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
      else if (type == TOP_LEVEL_DEFINITION) {
        return new UnisonTopLevelDefinitionImpl(node);
      }
      else if (type == TYPE_DECL) {
        return new UnisonTypeDeclImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new UnisonTypeExprImpl(node);
      }
      else if (type == TYPE_PARAMS) {
        return new UnisonTypeParamsImpl(node);
      }
      else if (type == USE_IMPORT) {
        return new UnisonUseImportImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
