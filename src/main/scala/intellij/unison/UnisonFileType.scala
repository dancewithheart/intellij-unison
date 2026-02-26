package intellij.unison

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.Icon

case class UnisonFileType()
    extends LanguageFileType(UnisonLanguage.INSTANCE) {

  override def getName: String = "Unison"

  override def getDescription: String = "Unison language file"

  override def getDefaultExtension: String = "u"

  override def getIcon: Icon = UnisonIcon.INSTANCE.FILE
}

object UnisonFileType {
  val INSTANCE: UnisonFileType = UnisonFileType()
}
