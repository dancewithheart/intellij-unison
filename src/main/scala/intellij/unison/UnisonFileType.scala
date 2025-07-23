package intellij.unison

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.Icon


case class UnisonFileType() extends LanguageFileType(UnisonLanguage.INSTANCE) {
  val INSTANCE: UnisonFileType.type = UnisonFileType

  override def getName: String = "Unison File"

  override def getDescription: String = "Unison language file"

  override def getDefaultExtension: String = "unison"

  override def getIcon: Icon = UnisonIcon.INSTANCE.FILE
}

