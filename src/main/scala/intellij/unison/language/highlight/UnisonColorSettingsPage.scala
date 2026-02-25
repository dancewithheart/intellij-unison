package intellij.unison.language.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import intellij.unison.UnisonIcon
import intellij.unison.language.highlight.UnisonColorSettingsPage.DESCRIPTORS

import java.util
import javax.swing.Icon

class UnisonColorSettingsPage
    extends ColorSettingsPage {

  override def getIcon: Icon = UnisonIcon.INSTANCE.FILE

  override def getHighlighter: SyntaxHighlighter = UnisonSyntaxHighlighter()

  override def getDemoText: String = "x = 42"

  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] =
    util.Map.of()

  override def getAttributeDescriptors: Array[AttributesDescriptor] =
    DESCRIPTORS

  override def getColorDescriptors: Array[ColorDescriptor] =
    ColorDescriptor.EMPTY_ARRAY

  override def getDisplayName: String = "Unison"
}

object UnisonColorSettingsPage {
  val DESCRIPTORS: Array[AttributesDescriptor] = Array(
    new AttributesDescriptor("Keyword", UnisonSyntaxHighlighter.KEYWORD),
    new AttributesDescriptor("Identifier", UnisonSyntaxHighlighter.IDENT),
    new AttributesDescriptor("Builtin type", UnisonSyntaxHighlighter.BUILTIN),
    new AttributesDescriptor("Literal", UnisonSyntaxHighlighter.LITERAL),
    new AttributesDescriptor("Punctuation / operators", UnisonSyntaxHighlighter.PUNCT),
    new AttributesDescriptor("Comment", UnisonSyntaxHighlighter.COMMENT),
    new AttributesDescriptor("Bad character", UnisonSyntaxHighlighter.BAD)
  )
}
