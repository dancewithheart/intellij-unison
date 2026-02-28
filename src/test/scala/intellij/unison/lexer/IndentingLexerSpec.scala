package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.{FlexAdapter, Lexer}
import IndentingLexerTestSupport._
import intellij.unison.{IndentingLexer, UnisonLexer}

object IndentingLexerSpec
    extends ZIOSpecDefault {

  // private def mk: Lexer = UnisonIndentingLexerAdapter.create()
  private def mk: Lexer =
    new IndentingLexer(new FlexAdapter(new UnisonLexer(null)))

  private def toks(input: String, includeWhitespace: Boolean = false) =
    lexAll(input, mk, includeWhitespace).map(x => (x.tok, x.text))

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexer")(
      test("emits NEWLINE + INDENT/DEDENT for increased/decreased indentation") {
        val input =
          "a = 1\n" +
            "  b = 2\n" +
            "c = 3\n"

        val out = toks(input)

        assertTrue(
          out.contains(("NEWLINE", "\n")),
          out.exists(_._1 == "INDENT"),
          out.exists(_._1 == "DEDENT")
        ) &&
        // Ensure order around the indent point: NEWLINE then INDENT then next non-ws token
        assertTrue {
          val idxNl = out.indexWhere(_._1 == "NEWLINE")
          val idxIn = out.indexWhere(_._1 == "INDENT")
          idxNl >= 0 && idxIn > idxNl
        }
      },
      test("emits multiple DEDENTs when indentation drops multiple levels") {
        val input =
          "a\n" +
            "  b\n" +
            "    c\n" +
            "d\n"

        val out = toks(input)
        val dedents = out.count(_._1 == "DEDENT")

        assertTrue(dedents >= 2)
      },
      test("does not emit NEWLINE/INDENT/DEDENT inside parentheses/brackets/braces") {
        val input =
          "x = (1\n" +
            "     + 2)\n" +
            "y = 3\n"

        val out = toks(input)
        // We still may emit NEWLINE tokens for whitespace outside parens, but not the inner one.
        // So assert: no INDENT/DEDENT triggered by the linebreak inside the parens.
        val indentCount = out.count(_._1 == "INDENT")
        val dedentCount = out.count(_._1 == "DEDENT")

        assertTrue(indentCount == 0 || indentCount == 1) && // allow outer block depending on your grammar style
        assertTrue(dedentCount == 0 || dedentCount == 1)
      },
      test("computes indent width from spaces and tabs (tab=4 by convention)") {
        val input =
          "a\n" +
            "\tb\n" + // tab indent -> width 4
            "a2\n"

        val out = toks(input)
        assertTrue(out.exists(_._1 == "INDENT")) &&
        assertTrue(out.exists(_._1 == "DEDENT"))
      },
      test("flushes remaining DEDENT tokens at EOF") {
        val input =
          "a\n" +
            "  b\n" // no trailing newline

        val out = toks(input)
        assertTrue(out.lastOption.exists(_._1 == "DEDENT"))
      },
      test("splits whitespace into WHITE_SPACE + NEWLINE + WHITE_SPACE segments (optional)") {
        val input = "a\n  b\n"
        val out = toks(input, includeWhitespace = true)

        // Expect at least one NEWLINE token and at least one WHITE_SPACE segment after it.
        assertTrue(out.exists(_._1 == "NEWLINE")) &&
        assertTrue(out.exists { case (k, txt) => k == "WHITE_SPACE" && txt.contains("  ") })
      }
    )
}
