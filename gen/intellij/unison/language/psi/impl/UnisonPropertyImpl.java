// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import intellij.unison.language.psi.*;
import com.intellij.navigation.ItemPresentation;

public class UnisonPropertyImpl extends UnisonNamedElementImpl implements UnisonProperty {

  public UnisonPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return UnisonPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return UnisonPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return UnisonPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return UnisonPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return UnisonPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return UnisonPsiImplUtil.getPresentation(this);
  }

}
