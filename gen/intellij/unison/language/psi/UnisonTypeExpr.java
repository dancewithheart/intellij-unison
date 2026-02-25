// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonTypeExpr extends PsiElement {

  @NotNull
  List<UnisonAddOp> getAddOpList();

  @Nullable
  UnisonIdentifier getIdentifier();

  @NotNull
  List<UnisonMulOp> getMulOpList();

  @NotNull
  List<UnisonOperatorId> getOperatorIdList();

  @Nullable
  UnisonBuiltinType getBuiltinType();

  @Nullable
  UnisonTypeExpr getTypeExpr();

}
