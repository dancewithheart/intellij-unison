// This is a generated file. Not intended for manual editing.
package intellij.unison.language.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;

public interface UnisonDeclaration extends UnisonNamedElement {

  String getKey();

  String getValue();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
