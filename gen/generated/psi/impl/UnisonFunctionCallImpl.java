// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import generated.psi.UnisonArgumentList;
import generated.psi.UnisonFunctionCall;
import generated.psi.UnisonIdentifier;
import generated.psi.UnisonVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UnisonFunctionCallImpl extends ASTWrapperPsiElement implements UnisonFunctionCall {

  public UnisonFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public UnisonIdentifier getIdentifier() {
    return findNotNullChildByClass(UnisonIdentifier.class);
  }

  @Override
  @Nullable
  public UnisonArgumentList getArgumentList() {
    return findChildByClass(UnisonArgumentList.class);
  }

}
