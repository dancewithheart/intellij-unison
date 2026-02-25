package intellij.unison.language

import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import intellij.unison.{UnisonLanguage, UnisonLexerAdapter}
import intellij.unison.language.parser.UnisonParser
import intellij.unison.language.psi.UnisonTypes

class UnisonParserDefinition
    extends ParserDefinition {

  override def createLexer(project: Project): Lexer = new UnisonLexerAdapter()

  override def createParser(project: Project): PsiParser = new UnisonParser()

  override def getFileNodeType: IFileElementType = UnisonParserDefinition.FILE

  override def getCommentTokens: TokenSet = UnisonTokenSets.COMMENTS

  override def getStringLiteralElements: TokenSet = UnisonTokenSets.STRING_LITERALS

  override def createElement(node: ASTNode): PsiElement =
    UnisonTypes.Factory.createElement(node)

  override def createFile(viewProvider: FileViewProvider): PsiFile =
    UnisonFile(viewProvider)
}

object UnisonParserDefinition {
  val FILE: IFileElementType = new IFileElementType(UnisonLanguage.INSTANCE)
}
