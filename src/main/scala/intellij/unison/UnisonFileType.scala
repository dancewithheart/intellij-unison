package intellij.unison

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

final class UnisonFileType private ()
    extends LanguageFileType(UnisonLanguage.INSTANCE) {

  override def getName: String = "Unison"
  override def getDescription: String = "Unison language file"
  override def getDefaultExtension: String = "u"
  override def getIcon: Icon = UnisonIcons.File
}

object UnisonFileType {
  val INSTANCE: UnisonFileType = new UnisonFileType()
}
