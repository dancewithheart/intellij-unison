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
          val tokens = IndentingLexerTestSupport.lexAll(input, mkAdapter)
          tokens.size == 1 &&
            tokens.head.tpe == UnisonTypes.CHAR_TOKEN &&
            tokens.head.text == input
        }

        assertTrue(valid)
      },
      test("character binding has exact tokens and offsets") {
        val input = "c3 = ?\\s"

        val tokens = IndentingLexerTestSupport.lexAll(
          input,
          mkAdapter,
          includeWhitespace = true
        )

        val actual = tokens.map(t => (t.tpe, t.text, t.start, t.end))

        val expected = Vector(
          (UnisonTypes.IDENTIFIER_TOKEN, "c3", 0, 2),
          (com.intellij.psi.TokenType.WHITE_SPACE, " ", 2, 3),
          (UnisonTypes.EQ, "=", 3, 4),
          (com.intellij.psi.TokenType.WHITE_SPACE, " ", 4, 5),
          (UnisonTypes.CHAR_TOKEN, "?\\s", 5, 8)
        )

        assertTrue(actual == expected)
          .label(IndentingLexerTestSupport.render(tokens))
      }
    )

  private def mkAdapter =
    new FlexAdapter(new UnisonLexer(null))
}
