// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.impl.*;

public interface UnisonTypes {

  IElementType DECLARATION = new UnisonElementType("DECLARATION");
  IElementType NAMESPACE_DECLARATION = new UnisonElementType("NAMESPACE_DECLARATION");
  IElementType NAMESPACE = new UnisonElementType("NAMESPACE");
  IElementType ABILITY = new UnisonElementType("ABILITY");
  IElementType MATCH = new UnisonElementType("MATCH");
  IElementType WITH = new UnisonElementType("WITH");

  IElementType COMMENT = new UnisonTokenType("COMMENT");

  IElementType TYPE = new UnisonTokenType("TYPE");
  IElementType BOOLEAN = new UnisonTokenType("BOOLEAN");
  IElementType STRING = new UnisonTokenType("STRING");
  IElementType NUMBER = new UnisonTokenType("NUMBER");

  IElementType ARROW = new UnisonTokenType("ARROW");
  IElementType COMMA = new UnisonTokenType("COMMA");
  IElementType STAR = new UnisonTokenType("STAR");

  IElementType LBRACE = new UnisonTokenType("LBRACE");
  IElementType RBRACE = new UnisonTokenType("RBRACE");
  IElementType LPAREN = new UnisonTokenType("LPAREN");
  IElementType RPAREN = new UnisonTokenType("RPAREN");
  IElementType DOT = new UnisonTokenType("DOT");
  IElementType UNDERSCORE = new UnisonTokenType("UNDERSCORE");
  IElementType EQ = new UnisonTokenType("EQ");
  IElementType BAR = new UnisonTokenType("BAR");
  IElementType LAMBDA = new UnisonTokenType("LAMBDA");

  IElementType IF = new UnisonTokenType("IF");
  IElementType THEN = new UnisonTokenType("THEN");
  IElementType ELSE = new UnisonTokenType("ELSE");
  IElementType USE = new UnisonTokenType("USE");
  IElementType LET = new UnisonTokenType("LET");


  IElementType IDENTIFIER = new UnisonTokenType("IDENTIFIER_TOKEN");

  IElementType CRLF = new UnisonTokenType("CRLF");
  IElementType SEPARATOR = new UnisonTokenType("SEPARATOR");
  IElementType VALUE = new UnisonTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DECLARATION) return new UnisonDeclarationImpl(node);
//      if (type == DECLARATION) return new UnisonDeclarationImpl(node); // TODO PP implement other types
      else if (type == NAMESPACE_DECLARATION) return new UnisonNamespaceDeclarationImpl(node);
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
