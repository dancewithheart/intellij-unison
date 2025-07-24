package intellij.unison

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement

import javax.swing.Icon
import com.intellij.ui.IconManager

case class UnisonIcon() extends IconProvider {

 val FILE: Icon =
   IconManager.getInstance.getIcon("/icons/unison2.png", getClass.getClassLoader)

  override def getIcon(element: PsiElement, flags: Int): Icon = UnisonIcon.INSTANCE.FILE
}

object UnisonIcon {
  val INSTANCE: UnisonIcon = UnisonIcon()
}




