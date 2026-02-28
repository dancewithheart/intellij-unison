package intellij.unison.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import intellij.unison.{UnisonFileType, UnisonLanguage}

// PSI root node for a Unison source file. IntelliJ creates this via ParserDefinition#createFile.
final class UnisonFile(viewProvider: FileViewProvider)
    extends PsiFileBase(viewProvider, UnisonLanguage.INSTANCE) {

  override def getFileType: FileType = UnisonFileType.INSTANCE
}
