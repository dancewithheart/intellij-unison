// This is a generated file. Not intended for manual editing.
package generated.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface UnisonExpression extends PsiElement {

  @Nullable
  UnisonIdentifier getIdentifier();

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
  UnisonQualifiedName getQualifiedName();

}
