package intellij.unison.language.highlight

import com.intellij.openapi.fileTypes.{SyntaxHighlighter, SyntaxHighlighterFactory}
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

final class UnisonSyntaxHighlighterFactory
    extends SyntaxHighlighterFactory {

  // IntelliJ asks for a highlighter per file/editor; return a stateless singleton.
  override def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter =
    UnisonSyntaxHighlighter.Instance
}
