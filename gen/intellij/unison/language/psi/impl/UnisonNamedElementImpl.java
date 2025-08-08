package intellij.unison.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import intellij.unison.language.psi.UnisonNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class UnisonNamedElementImpl extends ASTWrapperPsiElement implements UnisonNamedElement {

    public UnisonNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
