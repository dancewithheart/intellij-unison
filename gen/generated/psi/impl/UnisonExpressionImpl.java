// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import generated.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
  public UnisonIdentifier getIdentifier() {
    return findChildByClass(UnisonIdentifier.class);
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
  public UnisonQualifiedName getQualifiedName() {
    return findChildByClass(UnisonQualifiedName.class);
  }

}
