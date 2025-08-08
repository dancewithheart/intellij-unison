// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonBoolExpr extends PsiElement {

  @Nullable
  UnisonBoolean getBoolean();

  @Nullable
  UnisonBoolOperator getBoolOperator();

  @Nullable
  UnisonBoolExpr getBoolExpr();

  @Nullable
  UnisonQualifiedName getQualifiedName();

}
