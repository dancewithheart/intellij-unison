package intellij.unison

import com.intellij.lang.Language

// Language ID must match plugin.xml registration and is used as a key across IntelliJ services.
object UnisonLanguage
    extends Language("Unison") {
  val INSTANCE: UnisonLanguage.type = this
}
