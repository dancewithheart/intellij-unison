// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.impl.*;

public interface UnisonTypes {

  IElementType NAMESPACE_DECL = new UnisonElementType("NAMESPACE_DECL");
  IElementType NAMESPACE = new UnisonElementType("NAMESPACE");
  IElementType ABILITY_CONSTRUCTOR = new UnisonElementType("ABILITY_CONSTRUCTOR");
  IElementType ABILITY_DECL = new UnisonElementType("ABILITY_DECL");
  IElementType ABILITY = new UnisonElementType("ABILITY");
  IElementType MATCH = new UnisonElementType("MATCH");
  IElementType WITH = new UnisonElementType("WITH");

  IElementType COMMENT = new UnisonTokenType("COMMENT");

  IElementType ARGUMENT_LIST = new UnisonElementType("ARGUMENT_LIST");


  IElementType TYPE_DECL = new UnisonElementType("TYPE_DECL");
  IElementType TYPE_EXPR = new UnisonElementType("TYPE_EXPR");
  IElementType TYPE_PARAMS = new UnisonElementType("TYPE_PARAMS");
  IElementType TYPE = new UnisonTokenType("TYPE");
  IElementType BOOLEAN = new UnisonElementType("BOOLEAN");
  IElementType STRING = new UnisonElementType("STRING");
  IElementType NUMBER = new UnisonElementType("NUMBER");

  IElementType ARROW = new UnisonTokenType("ARROW");
  IElementType COMMA = new UnisonTokenType("COMMA");
  IElementType STAR = new UnisonTokenType("STAR");

  IElementType IF_EXPR = new UnisonElementType("IF_EXPR");

  IElementType CONSTRUCTOR = new UnisonElementType("CONSTRUCTOR");
  IElementType CONSTRUCTOR_PATTERN = new UnisonElementType("CONSTRUCTOR_PATTERN");
  IElementType DEFINITION = new UnisonElementType("DEFINITION");
  IElementType EXPRESSION = new UnisonElementType("EXPRESSION");
  IElementType FUNCTION_CALL = new UnisonElementType("FUNCTION_CALL");
  IElementType LITERAL = new UnisonElementType("LITERAL");
  IElementType MATCH_CASE = new UnisonElementType("MATCH_CASE");
  IElementType MATCH_EXPR = new UnisonElementType("MATCH_EXPR");

  IElementType PATTERN = new UnisonElementType("PATTERN");
  IElementType QUALIFIED_NAME = new UnisonElementType("QUALIFIED_NAME");
  IElementType STATEMENT = new UnisonElementType("STATEMENT");

  IElementType NUMBER_TOKEN = new UnisonTokenType("NUMBER_TOKEN");
  IElementType STRING_TOKEN = new UnisonTokenType("STRING_TOKEN");

  IElementType USE_IMPORT = new UnisonElementType("USE_IMPORT");

  IElementType LBRACE = new UnisonTokenType("LBRACE");
  IElementType RBRACE = new UnisonTokenType("RBRACE");
  IElementType LPAREN = new UnisonTokenType("LPAREN");
  IElementType RPAREN = new UnisonTokenType("RPAREN");
  IElementType DOT = new UnisonTokenType("DOT");
  IElementType UNDERSCORE = new UnisonTokenType("UNDERSCORE");
  IElementType EQ = new UnisonTokenType("EQ");
  IElementType BAR = new UnisonTokenType("BAR");
  IElementType LAMBDA = new UnisonElementType("LAMBDA");

  IElementType IF = new UnisonTokenType("IF");
  IElementType THEN = new UnisonTokenType("THEN");
  IElementType ELSE = new UnisonTokenType("ELSE");
  IElementType USE = new UnisonTokenType("USE");
  IElementType LET = new UnisonTokenType("LET");

  IElementType IDENTIFIER = new UnisonElementType("IDENTIFIER");
  IElementType IDENTIFIER_TOKEN = new UnisonTokenType("IDENTIFIER_TOKEN");

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
