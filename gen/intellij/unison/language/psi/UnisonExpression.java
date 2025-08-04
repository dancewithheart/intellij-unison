// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
