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

public class UnisonNumExprImpl extends ASTWrapperPsiElement implements UnisonNumExpr {

  public UnisonNumExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitNumExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UnisonNumOperator getNumOperator() {
    return findChildByClass(UnisonNumOperator.class);
  }

  @Override
  @Nullable
  public UnisonNumLiteral getNumLiteral() {
    return findChildByClass(UnisonNumLiteral.class);
  }

  @Override
  @NotNull
  public List<UnisonNumExpr> getNumExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonNumExpr.class);
  }

  @Override
  @Nullable
  public UnisonQualifiedName getQualifiedName() {
    return findChildByClass(UnisonQualifiedName.class);
  }

}
