package intellij.unison.lexer

import com.intellij.lexer.FlexAdapter
import intellij.unison.UnisonLexer
import intellij.unison.language.psi.UnisonTypes
import zio.test._

object UnisonCharLexerSpec extends ZIOSpecDefault {
  override def spec =
    suite("Character literals")(
      test("escape sequences are single tokens") {
        val inputs = Seq("?\\s", "?\\t", "?\\\\", "?H")

        val valid = inputs.forall { input =>
          val tokens = IndentingLexerTestSupport.lexAll(
            input,
            new FlexAdapter(new UnisonLexer(null))
          )

          tokens.size == 1 &&
            tokens.head.tpe == UnisonTypes.CHAR_TOKEN &&
            tokens.head.text == input
        }

        assertTrue(valid)
      }
    )
}
