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

public class UnisonLambdaImpl extends ASTWrapperPsiElement implements UnisonLambda {

  public UnisonLambdaImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitLambda(this);
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
  public List<UnisonPattern> getPatternList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonPattern.class);
  }

}
