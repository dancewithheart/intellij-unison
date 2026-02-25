// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonMatchExpr extends PsiElement {

  @NotNull
  List<UnisonExpression> getExpressionList();

  @NotNull
  List<UnisonMatchCase> getMatchCaseList();

  @NotNull
  PsiElement getDedent();

  @NotNull
  PsiElement getIndent();

  @NotNull
  PsiElement getNewline();

}
