package intellij.unison

import com.intellij.lexer.FlexAdapter

final class UnisonLexerAdapter
  extends IndentingLexer(new FlexAdapter(new UnisonLexer(null)))