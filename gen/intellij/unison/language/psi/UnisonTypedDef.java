// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonTypedDef extends PsiElement {

  @NotNull
  List<UnisonIdentifier> getIdentifierList();

  @NotNull
  UnisonFunBody getFunBody();

  @NotNull
  UnisonQualifiedName getQualifiedName();

  @NotNull
  UnisonTypeExpr getTypeExpr();

}
