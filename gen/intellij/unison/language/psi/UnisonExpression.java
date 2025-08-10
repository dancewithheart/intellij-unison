// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonExpression extends PsiElement {

  @Nullable
  UnisonBoolExpr getBoolExpr();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonFunctionCall getFunctionCall();

  @Nullable
  UnisonIfExpr getIfExpr();

  @Nullable
  UnisonLambda getLambda();

  @Nullable
  UnisonLiteral getLiteral();

  @Nullable
  UnisonMatchExpr getMatchExpr();

  @Nullable
  UnisonNumExpr getNumExpr();

  @Nullable
  UnisonQualifiedName getQualifiedName();

}
