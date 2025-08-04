package intellij.unison.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import intellij.unison.language.psi.UnisonElementFactory;
import intellij.unison.language.psi.UnisonProperty;
import intellij.unison.language.psi.UnisonTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class UnisonPsiImplUtil {

    public static String getKey(UnisonDeclaration element) {
        ASTNode keyNode = element.getNode().findChildByType(UnisonTypes.IDENTIFIER);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to Unison spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(UnisonDeclaration element) {
        ASTNode valueNode = element.getNode().findChildByType(UnisonTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(UnisonDeclaration element) {
        return getKey(element);
    }

    public static PsiElement setName(UnisonDeclaration element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(UnisonTypes.IDENTIFIER);
        if (keyNode != null) {
            UnisonDeclaration declaration = UnisonElementFactory.createDeclaration(element.getProject(), newName);
            ASTNode newKeyNode = declaration.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(UnisonDeclaration element) {
        ASTNode keyNode = element.getNode().findChildByType(UnisonTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final UnisonDeclaration element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

}
