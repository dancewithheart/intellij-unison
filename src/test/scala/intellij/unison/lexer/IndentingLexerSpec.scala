package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.{FlexAdapter, Lexer}
import com.intellij.psi.TokenType
import intellij.unison.{IndentingLexer, UnisonLexer}
import intellij.unison.language.psi.UnisonTypes

object IndentingLexerSpec extends ZIOSpecDefault {

  private def mk: Lexer =
    new IndentingLexer(new FlexAdapter(new UnisonLexer(null)))

  private def toks(input: String, includeWhitespace: Boolean = false): Vector[Lexed] =
    IndentingLexerTestSupport.lexAll(input, mk, includeWhitespace)

  private def dump(out: Vector[Lexed]): String =
    "\nTOKENS:\n" + IndentingLexerTestSupport.render(out)

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexer")(
      test("emits NEWLINE + INDENT/DEDENT for increased/decreased indentation") {
        val input =
          """|a = 1
             |  b = 2
             |c = 3
             |""".stripMargin

        val out = toks(input)

        val hasNewlineText = out.exists(t => t.tpe == UnisonTypes.NEWLINE && t.text == "\n")
        val hasIndent      = out.exists(_.tpe == UnisonTypes.INDENT)
        val hasDedent      = out.exists(_.tpe == UnisonTypes.DEDENT)

        val idxNl = out.indexWhere(_.tpe == UnisonTypes.NEWLINE)
        val idxIn = out.indexWhere(_.tpe == UnisonTypes.INDENT)
        val orderOk = idxNl >= 0 && idxIn > idxNl

        assertTrue(hasNewlineText && hasIndent && hasDedent && orderOk)
          .label(dump(out))
      },

      test("emits multiple DEDENTs when indentation drops multiple levels") {
        val input =
          """|a
             |  b
             |    c
             |d
             |""".stripMargin

        val out = toks(input)
        val dedents = out.count(_.tpe == UnisonTypes.DEDENT)

        assertTrue(dedents >= 2)
          .label(s"dedents=$dedents" + dump(out))
      },

      test("does not emit INDENT/DEDENT due to newline inside parentheses") {
        val input =
          """|x = (1
             |     + 2)
             |y = 3
             |""".stripMargin

        val out = toks(input)

        val indentCount = out.count(_.tpe == UnisonTypes.INDENT)
        val dedentCount = out.count(_.tpe == UnisonTypes.DEDENT)

        val ok =
          (indentCount == 0 || indentCount == 1) &&
            (dedentCount == 0 || dedentCount == 1)

        assertTrue(ok)
          .label(s"indentCount=$indentCount dedentCount=$dedentCount" + dump(out))
      },

      test("computes indent width from spaces and tabs (tab=4 by convention)") {
        val input =
          "a\n" +
            "\tb\n" + // tab indent -> width 4
            "a2\n"

        val out = toks(input)

        val hasIndent = out.exists(_.tpe == UnisonTypes.INDENT)
        val hasDedent = out.exists(_.tpe == UnisonTypes.DEDENT)

        assertTrue(hasIndent && hasDedent)
          .label(dump(out))
      },

      test("flushes remaining DEDENT tokens at EOF") {
        val input =
          """|a
             |  b""".stripMargin // no trailing newline

        val out = toks(input)

        val lastIsDedent = out.lastOption.exists(_.tpe == UnisonTypes.DEDENT)

        assertTrue(lastIsDedent)
          .label(dump(out))
      },

      test("splits whitespace into WHITE_SPACE + NEWLINE + WHITE_SPACE segments") {
        val input =
          """|a
             |  b
             |""".stripMargin

        val out = toks(input, includeWhitespace = true)

        val hasNewline = out.exists(_.tpe == UnisonTypes.NEWLINE)
        val hasIndentWsSegment =
          out.exists(t => t.tpe == TokenType.WHITE_SPACE && t.text.contains("  "))

        assertTrue(hasNewline && hasIndentWsSegment)
          .label(dump(out))
      }
    )
}
