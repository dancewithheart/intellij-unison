package intellij.unison.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import intellij.unison.UnisonFileType;
import intellij.unison.language.UnisonFile;

public class UnisonElementFactory {

    public static UnisonDeclaration createDeclaration(Project project, String name) {
        final UnisonFile file = createFile(project, name);
        return (UnisonDeclaration) file.getFirstChild();
    }

    public static UnisonFile createFile(Project project, String text) {
        String name = "dummy.unison";
        return (UnisonFile) PsiFileFactory.getInstance(project).createFileFromText(name, UnisonFileType.INSTANCE(), text);
    }

    public static UnisonDeclaration createDeclaration(Project project, String name, String value) {
        final UnisonFile file = createFile(project, name + " = " + value);
        return (UnisonDeclaration) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final UnisonFile file = createFile(project, "\n");
        return file.getFirstChild();
    }
}
