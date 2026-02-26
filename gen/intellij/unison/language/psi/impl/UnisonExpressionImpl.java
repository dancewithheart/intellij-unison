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

public class UnisonExpressionImpl extends ASTWrapperPsiElement implements UnisonExpression {

  public UnisonExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<UnisonAddOp> getAddOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonAddOp.class);
  }

  @Override
  @NotNull
  public List<UnisonIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonIdentifier.class);
  }

  @Override
  @NotNull
  public List<UnisonMulOp> getMulOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonMulOp.class);
  }

  @Override
  @NotNull
  public List<UnisonOperatorId> getOperatorIdList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonOperatorId.class);
  }

  @Override
  @Nullable
  public UnisonBinding getBinding() {
    return findChildByClass(UnisonBinding.class);
  }

  @Override
  @Nullable
  public UnisonBoolExpr getBoolExpr() {
    return findChildByClass(UnisonBoolExpr.class);
  }

  @Override
  @Nullable
  public UnisonBuiltinType getBuiltinType() {
    return findChildByClass(UnisonBuiltinType.class);
  }

  @Override
  @Nullable
  public UnisonCasesExpr getCasesExpr() {
    return findChildByClass(UnisonCasesExpr.class);
  }

  @Override
  @Nullable
  public UnisonCatchExpr getCatchExpr() {
    return findChildByClass(UnisonCatchExpr.class);
  }

  @Override
  @NotNull
  public List<UnisonExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonExpression.class);
  }

  @Override
  @Nullable
  public UnisonIfThenElseExpr getIfThenElseExpr() {
    return findChildByClass(UnisonIfThenElseExpr.class);
  }

  @Override
  @Nullable
  public UnisonLambda getLambda() {
    return findChildByClass(UnisonLambda.class);
  }

  @Override
  @Nullable
  public UnisonLetExpr getLetExpr() {
    return findChildByClass(UnisonLetExpr.class);
  }

  @Override
  @NotNull
  public List<UnisonLiteral> getLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonLiteral.class);
  }

  @Override
  @Nullable
  public UnisonMatchExpr getMatchExpr() {
    return findChildByClass(UnisonMatchExpr.class);
  }

  @Override
  @Nullable
  public UnisonNumExpr getNumExpr() {
    return findChildByClass(UnisonNumExpr.class);
  }

  @Override
  @Nullable
  public UnisonTypedDef getTypedDef() {
    return findChildByClass(UnisonTypedDef.class);
  }

  @Override
  @Nullable
  public UnisonUseClause getUseClause() {
    return findChildByClass(UnisonUseClause.class);
  }

}
