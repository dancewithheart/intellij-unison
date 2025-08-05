// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonNumExpr extends PsiElement {

  @Nullable
  UnisonNumOperator getNumOperator();

  @Nullable
  UnisonNumLiteral getNumLiteral();

  @NotNull
  List<UnisonNumExpr> getNumExprList();

  @Nullable
  UnisonQualifiedName getQualifiedName();

}
