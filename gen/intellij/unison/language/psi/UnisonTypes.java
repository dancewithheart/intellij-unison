// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.impl.*;

public interface UnisonTypes {

  IElementType PROPERTY = new UnisonElementType("PROPERTY");

  IElementType COMMENT = new UnisonTokenType("COMMENT");
  IElementType CRLF = new UnisonTokenType("CRLF");
  IElementType KEY = new UnisonTokenType("KEY");
  IElementType SEPARATOR = new UnisonTokenType("SEPARATOR");
  IElementType VALUE = new UnisonTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new UnisonPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
