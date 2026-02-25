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

public class UnisonUseClauseImpl extends ASTWrapperPsiElement implements UnisonUseClause {

  public UnisonUseClauseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitUseClause(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<UnisonBoolOperator> getBoolOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonBoolOperator.class);
  }

  @Override
  @NotNull
  public List<UnisonCompareOperator> getCompareOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonCompareOperator.class);
  }

  @Override
  @NotNull
  public List<UnisonNumOperator> getNumOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonNumOperator.class);
  }

  @Override
  @NotNull
  public List<UnisonQualifiedName> getQualifiedNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonQualifiedName.class);
  }

}
