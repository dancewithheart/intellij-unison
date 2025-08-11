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
    new AttributesDescriptor("IDENTIFIER", UnisonSyntaxHighlighter.IDENTIFIER),
    new AttributesDescriptor("Separator", UnisonSyntaxHighlighter.SEPARATOR),
    new AttributesDescriptor("NAMESPACE", UnisonSyntaxHighlighter.NAMESPACE),
    new AttributesDescriptor("LET", UnisonSyntaxHighlighter.LET),
    new AttributesDescriptor("MATCH", UnisonSyntaxHighlighter.MATCH),
    new AttributesDescriptor("USE", UnisonSyntaxHighlighter.USE),
    new AttributesDescriptor("TYPE", UnisonSyntaxHighlighter.TYPE),
    new AttributesDescriptor("ABILITY", UnisonSyntaxHighlighter.ABILITY),
    new AttributesDescriptor("CASES", UnisonSyntaxHighlighter.CASES),
    new AttributesDescriptor("STRUCTURAL", UnisonSyntaxHighlighter.STRUCTURAL),
    new AttributesDescriptor("String", UnisonSyntaxHighlighter.TEXT),
    new AttributesDescriptor("TEXT", UnisonSyntaxHighlighter.TEXT),
    new AttributesDescriptor("Int", UnisonSyntaxHighlighter.INT),
    new AttributesDescriptor("Nat", UnisonSyntaxHighlighter.NAT),
    new AttributesDescriptor("Double", UnisonSyntaxHighlighter.DOUBLE),
    new AttributesDescriptor("Boolean", UnisonSyntaxHighlighter.BOOLEAN),

    // TODO
    new AttributesDescriptor("Operators//Plus", UnisonSyntaxHighlighter.PLUS),
    new AttributesDescriptor("Operators//Minus", UnisonSyntaxHighlighter.MINUS),
    new AttributesDescriptor("Operators//Star", UnisonSyntaxHighlighter.STAR),
    new AttributesDescriptor("Operators//Mod", UnisonSyntaxHighlighter.MODS),
//    new AttributesDescriptor("Operators//Advanced//Sigma", UnisonSyntaxHighlighter.SIGMA),
//    new AttributesDescriptor("Operators//Advanced//Pi", UnisonSyntaxHighlighter.PI),

    new AttributesDescriptor("Bad value", UnisonSyntaxHighlighter.BAD_CHARACTER)
  )
}
