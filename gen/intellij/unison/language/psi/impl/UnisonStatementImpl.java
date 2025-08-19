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

public class UnisonStatementImpl extends ASTWrapperPsiElement implements UnisonStatement {

  public UnisonStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UnisonLineComment getLineComment() {
    return findChildByClass(UnisonLineComment.class);
  }

  @Override
  @Nullable
  public UnisonMultilineComment getMultilineComment() {
    return findChildByClass(UnisonMultilineComment.class);
  }

  @Override
  @Nullable
  public UnisonAbilityDecl getAbilityDecl() {
    return findChildByClass(UnisonAbilityDecl.class);
  }

  @Override
  @Nullable
  public UnisonDataType getDataType() {
    return findChildByClass(UnisonDataType.class);
  }

  @Override
  @Nullable
  public UnisonExpression getExpression() {
    return findChildByClass(UnisonExpression.class);
  }

  @Override
  @Nullable
  public UnisonNamespaceDecl getNamespaceDecl() {
    return findChildByClass(UnisonNamespaceDecl.class);
  }

}
