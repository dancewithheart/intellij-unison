// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class UnisonConstructorPatternImpl extends ASTWrapperPsiElement implements UnisonConstructorPattern {

  public UnisonConstructorPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitConstructorPattern(this);
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
  @NotNull
  public List<UnisonPattern> getPatternList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonPattern.class);
  }

}
