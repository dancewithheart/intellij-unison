// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonCasesExpr extends PsiElement {

  @NotNull
  List<UnisonExpression> getExpressionList();

  @NotNull
  List<UnisonGuardPattern> getGuardPatternList();

  @NotNull
  PsiElement getDedent();

  @NotNull
  PsiElement getIndent();

}
