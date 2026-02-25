// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonPattern extends PsiElement {

  @Nullable
  UnisonAddOp getAddOp();

  @Nullable
  UnisonIdentifier getIdentifier();

  @Nullable
  UnisonMulOp getMulOp();

  @Nullable
  UnisonOperatorId getOperatorId();

  @Nullable
  UnisonLiteral getLiteral();

  @Nullable
  UnisonPattern getPattern();

}
