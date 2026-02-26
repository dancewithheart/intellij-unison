// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static intellij.unison.language.psi.UnisonTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import intellij.unison.language.psi.*;

public class UnisonCasesExprImpl extends ASTWrapperPsiElement implements UnisonCasesExpr {

  public UnisonCasesExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitCasesExpr(this);
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

  @Override
  @NotNull
  public List<UnisonGuardPattern> getGuardPatternList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonGuardPattern.class);
  }

  @Override
  @NotNull
  public PsiElement getDedent() {
    return findNotNullChildByType(DEDENT);
  }

  @Override
  @NotNull
  public PsiElement getIndent() {
    return findNotNullChildByType(INDENT);
  }

}
