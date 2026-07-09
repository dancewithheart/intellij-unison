package intellij.unison.perf

import scala.io.Source
import scala.util.Using

object Resource {
  def readUtf8(path: String, cl: ClassLoader): String = {
    val is =
      Option(cl.getResourceAsStream(path))
        .getOrElse(throw new IllegalStateException(s"$path not found on classpath"))

    Using.resource(is) { is =>
      Using.resource(Source.fromInputStream(is, "UTF-8"))(_.mkString)
    }
  }
}
