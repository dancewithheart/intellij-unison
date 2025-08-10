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

public class UnisonBoolExprImpl extends ASTWrapperPsiElement implements UnisonBoolExpr {

  public UnisonBoolExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitBoolExpr(this);
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
  public UnisonBoolOperator getBoolOperator() {
    return findChildByClass(UnisonBoolOperator.class);
  }

  @Override
  @Nullable
  public UnisonIdentifier getIdentifier() {
    return findChildByClass(UnisonIdentifier.class);
  }

  @Override
  @Nullable
  public UnisonBoolExpr getBoolExpr() {
    return findChildByClass(UnisonBoolExpr.class);
  }

}
