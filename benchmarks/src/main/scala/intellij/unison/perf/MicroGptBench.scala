package intellij.unison.perf

import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

import intellij.unison.UnisonLexerAdapter

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 8, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(2)
@State(Scope.Thread)
class MicroGptBench {

  private var text: String = _

  @Setup(Level.Trial)
  def setup(): Unit = {
    text = Resource.readUtf8("micro_gpt.u", getClass.getClassLoader)
  }

  @Benchmark
  def lexWholeFile(): Int = {
    val lexer = new UnisonLexerAdapter()
    lexer.start(text, 0, text.length, 0)

    var n = 0
    while (lexer.getTokenType != null) {
      n += 1
      lexer.advance()
    }
    n
  }
}