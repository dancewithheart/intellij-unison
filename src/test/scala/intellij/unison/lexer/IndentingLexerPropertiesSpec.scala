package intellij.unison.lexer

import zio.test._
import com.intellij.lexer.Lexer
import intellij.unison.{IndentingLexer, UnisonLexerAdapter}
import intellij.unison.language.psi.UnisonTypes
import intellij.unison.lexer.IndentingLexerTestSupport._

import java.nio.file.{Files, Paths}

object IndentingLexerPropertiesSpec
    extends ZIOSpecDefault {

  private def mk: Lexer =
    new IndentingLexer(new FakeWhitespaceLexer)

  private def toks(input: String, includeWhitespace: Boolean = false): Vector[Lexed] =
    lexAll(input, mk, includeWhitespace)

  private def indentBalance(tokens: Seq[Lexed]): Vector[Int] =
    tokens.foldLeft(Vector(0)) { (acc, t) =>
      val bal = acc.last
      val next =
        if (t.tpe == UnisonTypes.INDENT) bal + 1
        else if (t.tpe == UnisonTypes.DEDENT) bal - 1
        else bal
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
        val genNoNl =
          Gen.string(Gen.printableChar).map(_.filterNot(_ == '\n').take(300))

        check(genNoNl) { s =>
          val out = toks(s)
          val types = out.map(_.tpe).toSet

          assertTrue(!types.contains(UnisonTypes.NEWLINE)) &&
          assertTrue(!types.contains(UnisonTypes.INDENT)) &&
          assertTrue(!types.contains(UnisonTypes.DEDENT))
        }
      },
      test("token offsets are monotonic and well-formed") {
        check(Gen.string(Gen.printableChar).map(_.take(300))) { s =>
          val out = toks(s, includeWhitespace = true)

          val wellFormed =
            out.forall(t => t.start <= t.end && t.start >= 0 && t.end >= 0)

          val monotonicStarts =
            out.map(_.start).sliding(2).forall {
              case Seq(a, b) => a <= b
              case _         => true
            }

          val nonOverlapping =
            out.sliding(2).forall {
              case Seq(a, b) => a.end <= b.start
              case _         => true
            }

          assertTrue(wellFormed && monotonicStarts && nonOverlapping)
        }
      },
      test("Concurrency.u produces non-overlapping tokens") {
        val input = Files.readString(
          Paths.get("src/test/testData/wip/Concurrency.u")
        ).trim

        // Use the REAL lexer, not FakeWhitespaceLexer.
        val out = lexAll(
          input,
          new UnisonLexerAdapter,
          includeWhitespace = true
        )

        val violations =
          out.sliding(2).collect {
            case Seq(a, b) if a.end > b.start =>
              s"${a.name} [${a.start}, ${a.end}) -> " +
                s"${b.name} [${b.start}, ${b.end})"
          }.toVector

        assertTrue(violations.isEmpty)
          .label(
            s"Overlapping tokens:\n${violations.mkString("\n")}\n" +
              IndentingLexerTestSupport.render(out)
          )
      },
      test("generated indentation preserves token ordering") {

        val programs = for {
          eol <- Gen.elements("\n", "\r\n")
          widths <- Gen.listOfBounded(0, 6)(Gen.int(0, 4))
        } yield {
          val prefix = Vector(
            "root = 0",
            "  child = 1",
            "    grandchild = 2"
          )

          val generated = widths.zipWithIndex.map {
            case (depth, i) =>
              ("  " * depth) + s"x$i = $i"
          }

          (prefix ++ generated ++ Vector("last = 3"))
            .mkString(eol)
        }

        check(programs) { input =>
          val out = lexAll(
            input,
            new UnisonLexerAdapter,
            includeWhitespace = true
          )

          val valid = out.sliding(2).forall {
            case Seq(a, b) => a.end <= b.start
            case _         => true
          }

          assertTrue(valid).label(
            s"INPUT:\n$input\n\nTOKENS:\n${IndentingLexerTestSupport.render(out)}"
          )
        }
      },
      test("no INDENT/DEDENT caused by newlines inside parentheses") {
        val gen = for {
          prefix <- Gen.string(Gen.alphaChar).map(_.take(10))
          bodyLines <- Gen.listOfBounded(1, 10)(Gen.string(Gen.alphaChar).map(_.take(10)))
          suffix <- Gen.string(Gen.alphaChar).map(_.take(10))
        } yield {
          val body = bodyLines.mkString("\n  ", "\n  ", "\n") // includes newlines + indentation
          s"$prefix($body)$suffix\nx\n  y\n" // outer block so INDENT/DEDENT can still appear
        }

        check(gen) { s =>
          val out = toks(s)

          val indentCount = out.count(_.tpe == UnisonTypes.INDENT)
          val dedentCount = out.count(_.tpe == UnisonTypes.DEDENT)

          assertTrue(indentCount <= 1) &&
          assertTrue(dedentCount <= 1)
        }
      }
    )
}
