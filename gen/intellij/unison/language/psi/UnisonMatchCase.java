// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonMatchCase extends PsiElement {

  @NotNull
  List<UnisonExpression> getExpressionList();

  @NotNull
  List<UnisonGuardPattern> getGuardPatternList();

  @NotNull
  UnisonPattern getPattern();

  @NotNull
  PsiElement getNewline();

}
