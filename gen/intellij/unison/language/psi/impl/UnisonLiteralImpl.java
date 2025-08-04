// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import intellij.unison.language.psi.*;

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
  public UnisonChar getChar() {
    return findChildByClass(UnisonChar.class);
  }

  @Override
  @Nullable
  public UnisonDouble getDouble() {
    return findChildByClass(UnisonDouble.class);
  }

  @Override
  @Nullable
  public UnisonInt getInt() {
    return findChildByClass(UnisonInt.class);
  }

  @Override
  @Nullable
  public UnisonText getString() {
    return findChildByClass(UnisonText.class);
  }

}
