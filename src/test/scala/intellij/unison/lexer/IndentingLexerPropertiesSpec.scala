package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.Lexer
import intellij.unison.IndentingLexer
import intellij.unison.lexer.IndentingLexerTestSupport._

object IndentingLexerPropertiesSpec
    extends ZIOSpecDefault {

  private def mk: Lexer =
    new IndentingLexer(new FakeWhitespaceLexer)

  private def toks(input: String, includeWhitespace: Boolean = false) =
    lexAll(input, mk, includeWhitespace).map(x => (x.tok, x.text, x.start, x.end)) // likely Vector

  private def indentBalance(tokens: Seq[(String, String, Int, Int)]): Vector[Int] =
    tokens.foldLeft(Vector(0)) { (acc, t) =>
      val bal = acc.last
      val next = t._1 match {
        case "INDENT" => bal + 1
        case "DEDENT" => bal - 1
        case _        => bal
      }
      acc :+ next
    }

  override def spec: Spec[TestEnvironment, Any] =
    suite("IndentingLexer - properties")(
      test("INDENT/DEDENT never goes negative and ends balanced") {
        check(Gen.string(Gen.printableChar).map(_.take(300))) { s =>
          val out = toks(s)
          val bal = indentBalance(out)

          assertTrue(bal.forall(_ >= 0)) &&
          assertTrue(bal.lastOption.getOrElse(0) == 0)
        }
      },
      test("no newline => no NEWLINE/INDENT/DEDENT") {
        val genNoNl = Gen.string(Gen.printableChar).map(_.filterNot(_ == '\n').take(300))
        check(genNoNl) { s =>
          val out = toks(s)
          val kinds = out.map(_._1).toSet
          assertTrue(!kinds.contains("NEWLINE")) &&
          assertTrue(!kinds.contains("INDENT")) &&
          assertTrue(!kinds.contains("DEDENT"))
        }
      },
      test("token offsets are monotonic and well-formed") {
        check(Gen.string(Gen.printableChar).map(_.take(300))) { s =>
          val out = toks(s, includeWhitespace = true)

          val wellFormed =
            out.forall { case (_, _, st, en) => st <= en && st >= 0 && en >= 0 }

          val monotonicStarts =
            out.map(_._3).sliding(2).forall {
              case Seq(a, b) => a <= b
              case _         => true
            }

          assertTrue(wellFormed && monotonicStarts)
        }
      },
      test("no INDENT/DEDENT caused by newlines inside parentheses") {
        val gen = for {
          prefix <- Gen.string(Gen.alphaChar).map(_.take(10))
          bodyLines <- Gen.listOfBounded(1, 10)(Gen.string(Gen.alphaChar).map(_.take(10)))
          suffix <- Gen.string(Gen.alphaChar).map(_.take(10))
        } yield {
          val body = bodyLines.mkString("\n  ", "\n  ", "\n")
          s"$prefix($body)$suffix\nx\n  y\n"
        }

        check(gen) { s =>
          val out = toks(s)
          val indentCount = out.count(_._1 == "INDENT")
          val dedentCount = out.count(_._1 == "DEDENT")

          assertTrue(indentCount <= 1) && assertTrue(dedentCount <= 1)
        }
      }
    )
}
