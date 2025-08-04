// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonStatement extends PsiElement {

  @Nullable
  UnisonAbilityDecl getAbilityDecl();

  @Nullable
  UnisonDefinition getDefinition();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonNamespaceDecl getNamespaceDecl();

  @Nullable
  UnisonTypeDecl getTypeDecl();

  @Nullable
  UnisonUseImport getUseImport();

}
