// This is a generated file. Not intended for manual editing.
package generated.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static intellij.unison.language.psi.UnisonTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class UnisonPatternImpl extends ASTWrapperPsiElement implements UnisonPattern {

  public UnisonPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UnisonVisitor visitor) {
    visitor.visitPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UnisonVisitor) accept((UnisonVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UnisonIdentifier getIdentifier() {
    return findChildByClass(UnisonIdentifier.class);
  }

  @Override
  @Nullable
  public UnisonConstructorPattern getConstructorPattern() {
    return findChildByClass(UnisonConstructorPattern.class);
  }

  @Override
  @Nullable
  public UnisonLiteral getLiteral() {
    return findChildByClass(UnisonLiteral.class);
  }

  @Override
  @Nullable
  public UnisonPattern getPattern() {
    return findChildByClass(UnisonPattern.class);
  }

}
