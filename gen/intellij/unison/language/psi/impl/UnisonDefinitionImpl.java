// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import intellij.unison.language.psi.*;

public class UnisonDefinitionImpl extends ASTWrapperPsiElement implements UnisonDefinition {

  public UnisonDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public UnisonIdentifier getIdentifier() {
    return findNotNullChildByClass(UnisonIdentifier.class);
  }

  @Override
  @NotNull
  public UnisonExpression getExpression() {
    return findNotNullChildByClass(UnisonExpression.class);
  }

}
