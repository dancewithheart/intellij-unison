// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UnisonStatement extends PsiElement {

  @Nullable
  UnisonLineComment getLineComment();

  @Nullable
  UnisonMultilineComment getMultilineComment();

  @Nullable
  UnisonAbilityDecl getAbilityDecl();

  @Nullable
  UnisonExpression getExpression();

  @Nullable
  UnisonNamespaceDecl getNamespaceDecl();

  @Nullable
  UnisonTypeDecl getTypeDecl();

}
