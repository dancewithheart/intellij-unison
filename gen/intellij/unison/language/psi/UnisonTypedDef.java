// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonTypedDef extends PsiElement {

  @NotNull
  List<UnisonIdentifier> getIdentifierList();

  @Nullable
  UnisonDelayedType getDelayedType();

  @NotNull
  UnisonFunBody getFunBody();

  @Nullable
  UnisonPolymorphicType getPolymorphicType();

  @NotNull
  UnisonQualifiedName getQualifiedName();

  @NotNull
  List<UnisonTypeExpr> getTypeExprList();

}
