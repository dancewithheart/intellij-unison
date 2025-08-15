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
  public UnisonCasesExpr getCasesExpr() {
    return findChildByClass(UnisonCasesExpr.class);
  }

  @Override
  @Nullable
  public UnisonCatchExpr getCatchExpr() {
    return findChildByClass(UnisonCatchExpr.class);
  }

  @Override
  @Nullable
  public UnisonExpression getExpression() {
    return findChildByClass(UnisonExpression.class);
  }

  @Override
  @Nullable
  public UnisonFunctionCall getFunctionCall() {
    return findChildByClass(UnisonFunctionCall.class);
  }

  @Override
  @Nullable
  public UnisonIfExpr getIfExpr() {
    return findChildByClass(UnisonIfExpr.class);
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
  @Nullable
  public UnisonLiteral getLiteral() {
    return findChildByClass(UnisonLiteral.class);
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
  public UnisonQualifiedImport getQualifiedImport() {
    return findChildByClass(UnisonQualifiedImport.class);
  }

  @Override
  @Nullable
  public UnisonQualifiedName getQualifiedName() {
    return findChildByClass(UnisonQualifiedName.class);
  }

  @Override
  @Nullable
  public UnisonTypedDef getTypedDef() {
    return findChildByClass(UnisonTypedDef.class);
  }

  @Override
  @Nullable
  public UnisonUseImport getUseImport() {
    return findChildByClass(UnisonUseImport.class);
  }

}
