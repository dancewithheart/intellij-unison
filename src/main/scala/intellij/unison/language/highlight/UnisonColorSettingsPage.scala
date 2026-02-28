package intellij.unison.language.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import intellij.unison.UnisonIcons

import java.util
import javax.swing.Icon

final class UnisonColorSettingsPage
    extends ColorSettingsPage {

  // Settings UI only: this icon is shown in the color scheme editor.
  override def getIcon: Icon = UnisonIcons.File

  // IntelliJ may call this often while rendering the preview; keep it allocation-free.
  override def getHighlighter: SyntaxHighlighter = UnisonSyntaxHighlighter.Instance

  // Purely a preview snippet for color settings (not a parser/PSI test).
  override def getDemoText: String =
    """|-- Unison syntax highlighting preview
       |x = 42
       |""".stripMargin

  // We don't use custom <tag>...</tag> highlighting in demo text.
  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] =
    util.Map.of()

  override def getAttributeDescriptors: Array[AttributesDescriptor] =
    UnisonColorSettingsPage.Descriptors

  override def getColorDescriptors: Array[ColorDescriptor] =
    ColorDescriptor.EMPTY_ARRAY

  override def getDisplayName: String = "Unison"
}

object UnisonColorSettingsPage {
  // These are the only knobs users see in Settings | Editor | Color Scheme | Unison.
  val Descriptors: Array[AttributesDescriptor] = Array(
    new AttributesDescriptor("Keyword", UnisonSyntaxHighlighter.KEYWORD),
    new AttributesDescriptor("Identifier", UnisonSyntaxHighlighter.IDENT),
    new AttributesDescriptor("Builtin type", UnisonSyntaxHighlighter.BUILTIN),
    new AttributesDescriptor("Literal", UnisonSyntaxHighlighter.LITERAL),
    new AttributesDescriptor("Punctuation / operators", UnisonSyntaxHighlighter.PUNCT),
    new AttributesDescriptor("Comment", UnisonSyntaxHighlighter.COMMENT),
    new AttributesDescriptor("Bad character", UnisonSyntaxHighlighter.BAD)
  )
}
