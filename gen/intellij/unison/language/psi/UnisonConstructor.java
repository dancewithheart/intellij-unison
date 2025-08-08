// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonConstructor extends PsiElement {

  @NotNull
  UnisonQualifiedName getQualifiedName();

  @NotNull
  List<UnisonTypeExpr> getTypeExprList();

}
