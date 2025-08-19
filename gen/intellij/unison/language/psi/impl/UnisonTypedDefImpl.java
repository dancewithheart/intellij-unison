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

public class UnisonTypedDefImpl extends ASTWrapperPsiElement implements UnisonTypedDef {

  public UnisonTypedDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitTypedDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<UnisonAbilityRequirements> getAbilityRequirementsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonAbilityRequirements.class);
  }

  @Override
  @Nullable
  public UnisonDelayedType getDelayedType() {
    return findChildByClass(UnisonDelayedType.class);
  }

  @Override
  @NotNull
  public UnisonFunBody getFunBody() {
    return findNotNullChildByClass(UnisonFunBody.class);
  }

  @Override
  @Nullable
  public UnisonPolymorphicType getPolymorphicType() {
    return findChildByClass(UnisonPolymorphicType.class);
  }

  @Override
  @NotNull
  public UnisonQualifiedName getQualifiedName() {
    return findNotNullChildByClass(UnisonQualifiedName.class);
  }

  @Override
  @NotNull
  public List<UnisonTypeExpr> getTypeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonTypeExpr.class);
  }

}
