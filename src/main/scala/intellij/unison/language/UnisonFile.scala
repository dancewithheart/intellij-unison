package intellij.unison.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import intellij.unison.{UnisonFileType, UnisonLanguage}

// top-level node of tree of PsiElements for a Unison file
case class UnisonFile(viewProvider: FileViewProvider)
  extends PsiFileBase(viewProvider, UnisonLanguage.INSTANCE) {


  override def getFileType: FileType = UnisonFileType.INSTANCE
}
