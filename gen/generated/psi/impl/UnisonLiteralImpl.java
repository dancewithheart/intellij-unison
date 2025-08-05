// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import generated.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UnisonLiteralImpl extends ASTWrapperPsiElement implements UnisonLiteral {

  public UnisonLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UnisonBoolean getBoolean() {
    return findChildByClass(UnisonBoolean.class);
  }

  @Override
  @Nullable
  public UnisonNumber getNumber() {
    return findChildByClass(UnisonNumber.class);
  }

  @Override
  @Nullable
  public UnisonString getString() {
    return findChildByClass(UnisonString.class);
  }

}
