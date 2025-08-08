// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
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
  UnisonTopLevelDefinition getTopLevelDefinition();

  @Nullable
  UnisonTopLevelTypeDefinition getTopLevelTypeDefinition();

  @Nullable
  UnisonTypeDecl getTypeDecl();

  @Nullable
  UnisonUseImport getUseImport();

}
