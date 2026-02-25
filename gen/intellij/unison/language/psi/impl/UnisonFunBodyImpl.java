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

public class UnisonFunBodyImpl extends ASTWrapperPsiElement implements UnisonFunBody {

  public UnisonFunBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitFunBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UnisonExpression getExpression() {
    return findChildByClass(UnisonExpression.class);
  }

  @Override
  @NotNull
  public List<UnisonStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, UnisonStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getDedent() {
    return findChildByType(DEDENT);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(INDENT);
  }

}
