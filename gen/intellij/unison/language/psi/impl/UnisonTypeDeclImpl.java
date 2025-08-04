// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import intellij.unison.language.psi.*;

public class UnisonTypeDeclImpl extends ASTWrapperPsiElement implements UnisonTypeDecl {

  public UnisonTypeDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitTypeDecl(this);
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
  public List<UnisonConstructor> getConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonConstructor.class);
  }

  @Override
  @Nullable
  public UnisonTypeParams getTypeParams() {
    return findChildByClass(UnisonTypeParams.class);
  }

}
