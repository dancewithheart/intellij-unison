// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonStatement extends PsiElement {

  @NotNull
  List<UnisonAddOp> getAddOpList();

  @NotNull
  List<UnisonIdentifier> getIdentifierList();

  @NotNull
  List<UnisonMulOp> getMulOpList();

  @NotNull
  List<UnisonOperatorId> getOperatorIdList();

  @Nullable
  UnisonAbilityDecl getAbilityDecl();

  @Nullable
  UnisonDataType getDataType();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonNamespaceDecl getNamespaceDecl();

  @Nullable
  UnisonPolymorphicType getPolymorphicType();

  @Nullable
  UnisonTypeExpr getTypeExpr();

  @Nullable
  PsiElement getNewline();

}
