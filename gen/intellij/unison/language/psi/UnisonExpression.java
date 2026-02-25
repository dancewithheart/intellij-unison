// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonExpression extends PsiElement {

  @NotNull
  List<UnisonAddOp> getAddOpList();

  @NotNull
  List<UnisonIdentifier> getIdentifierList();

  @NotNull
  List<UnisonMulOp> getMulOpList();

  @NotNull
  List<UnisonOperatorId> getOperatorIdList();

  @Nullable
  UnisonBinding getBinding();

  @Nullable
  UnisonBoolExpr getBoolExpr();

  @Nullable
  UnisonBuiltinType getBuiltinType();

  @Nullable
  UnisonCasesExpr getCasesExpr();

  @Nullable
  UnisonCatchExpr getCatchExpr();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonFunctionCall getFunctionCall();

  @Nullable
  UnisonIfThenElseExpr getIfThenElseExpr();

  @Nullable
  UnisonLambda getLambda();

  @Nullable
  UnisonLetExpr getLetExpr();

  @Nullable
  UnisonLiteral getLiteral();

  @Nullable
  UnisonMatchExpr getMatchExpr();

  @Nullable
  UnisonNumExpr getNumExpr();

  @Nullable
  UnisonTypedDef getTypedDef();

  @Nullable
  UnisonUseClause getUseClause();

}
