// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonExpression extends PsiElement {

  @Nullable
  UnisonBinding getBinding();

  @Nullable
  UnisonBoolExpr getBoolExpr();

  @Nullable
  UnisonCasesExpr getCasesExpr();

  @Nullable
  UnisonCatchExpr getCatchExpr();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonFunctionCall getFunctionCall();

  @Nullable
  UnisonIfExpr getIfExpr();

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
  UnisonQualifiedImport getQualifiedImport();

  @Nullable
  UnisonQualifiedName getQualifiedName();

  @Nullable
  UnisonTypedDef getTypedDef();

  @Nullable
  UnisonUseImport getUseImport();

}
