// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonBoolExpr extends PsiElement {

  @NotNull
  List<UnisonBoolean> getBooleanList();

  @NotNull
  List<UnisonBoolOperator> getBoolOperatorList();

  @NotNull
  List<UnisonCompareOperator> getCompareOperatorList();

  @NotNull
  List<UnisonBoolExpr> getBoolExprList();

  @NotNull
  List<UnisonNumExpr> getNumExprList();

  @NotNull
  List<UnisonQualifiedName> getQualifiedNameList();

}
