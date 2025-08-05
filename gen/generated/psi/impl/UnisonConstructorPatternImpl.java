// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import generated.psi.UnisonConstructorPattern;
import generated.psi.UnisonIdentifier;
import generated.psi.UnisonPattern;
import generated.psi.UnisonVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
