// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonUseClause extends PsiElement {

  @NotNull
  List<UnisonAddOp> getAddOpList();

  @NotNull
  List<UnisonBoolOperator> getBoolOperatorList();

  @NotNull
  List<UnisonCompareOperator> getCompareOperatorList();

  @NotNull
  List<UnisonIdentifier> getIdentifierList();

  @NotNull
  List<UnisonMulOp> getMulOpList();

  @NotNull
  List<UnisonOperatorId> getOperatorIdList();

  @NotNull
  List<UnisonBuiltinType> getBuiltinTypeList();

}
