// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class UnisonVisitor extends PsiElementVisitor {

  public void visitDeclaration(@NotNull UnisonDeclaration o) {
    visitNamedElement(o);
  }

  public void visitNamespaceDeclaration(@NotNull UnisonNamespaceDeclaration o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull UnisonNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }
}
