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

public class UnisonDataTypeImpl extends ASTWrapperPsiElement implements UnisonDataType {

  public UnisonDataTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitDataType(this);
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
  @NotNull
  public List<UnisonDataConstructor> getDataConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonDataConstructor.class);
  }

}
