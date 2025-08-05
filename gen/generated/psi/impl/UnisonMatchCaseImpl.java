// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import generated.psi.UnisonExpression;
import generated.psi.UnisonMatchCase;
import generated.psi.UnisonPattern;
import generated.psi.UnisonVisitor;
import org.jetbrains.annotations.NotNull;

public class UnisonMatchCaseImpl extends ASTWrapperPsiElement implements UnisonMatchCase {

  public UnisonMatchCaseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitMatchCase(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public UnisonExpression getExpression() {
    return findNotNullChildByClass(UnisonExpression.class);
  }

  @Override
  @NotNull
  public UnisonPattern getPattern() {
    return findNotNullChildByClass(UnisonPattern.class);
  }

}
