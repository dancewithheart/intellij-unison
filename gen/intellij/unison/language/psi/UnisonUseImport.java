// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonUseImport extends PsiElement {

  @NotNull
  List<UnisonBoolOperator> getBoolOperatorList();

  @NotNull
  List<UnisonCompareOperator> getCompareOperatorList();

  @NotNull
  List<UnisonNumOperator> getNumOperatorList();

  @NotNull
  List<UnisonQualifiedImport> getQualifiedImportList();

  @NotNull
  List<UnisonQualifiedName> getQualifiedNameList();

}
