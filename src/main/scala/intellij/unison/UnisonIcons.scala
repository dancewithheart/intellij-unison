package intellij.unison

import com.intellij.ui.IconManager
import javax.swing.Icon

/** Central place for plugin icons (no IconProvider; file type decides where icon is used). */
object UnisonIcons {
  lazy val File: Icon =
    IconManager.getInstance.getIcon("/icons/unison.svg", getClass.getClassLoader)
}
