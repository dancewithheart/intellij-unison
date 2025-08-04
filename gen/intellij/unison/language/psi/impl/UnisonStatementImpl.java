// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
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
  public UnisonAbilityDecl getAbilityDecl() {
    return findChildByClass(UnisonAbilityDecl.class);
  }

  @Override
  @Nullable
  public UnisonDefinition getDefinition() {
    return findChildByClass(UnisonDefinition.class);
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

  @Override
  @Nullable
  public UnisonTopLevelDefinition getTopLevelDefinition() {
    return findChildByClass(UnisonTopLevelDefinition.class);
  }

  @Override
  @Nullable
  public UnisonTypeDecl getTypeDecl() {
    return findChildByClass(UnisonTypeDecl.class);
  }

  @Override
  @Nullable
  public UnisonUseImport getUseImport() {
    return findChildByClass(UnisonUseImport.class);
  }

}
