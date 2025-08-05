// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import generated.psi.UnisonExpression;
import generated.psi.UnisonIfExpr;
import generated.psi.UnisonVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnisonIfExprImpl extends ASTWrapperPsiElement implements UnisonIfExpr {

  public UnisonIfExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitIfExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<UnisonExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonExpression.class);
  }

}
