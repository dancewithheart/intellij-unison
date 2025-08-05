// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import generated.psi.UnisonConstructor;
import generated.psi.UnisonIdentifier;
import generated.psi.UnisonTypeExpr;
import generated.psi.UnisonVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnisonConstructorImpl extends ASTWrapperPsiElement implements UnisonConstructor {

  public UnisonConstructorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitConstructor(this);
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
  public List<UnisonTypeExpr> getTypeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonTypeExpr.class);
  }

}
