package coursier.echo

object Echo {
  def main(args: Array[String]): Unit = {

    val (printNewLine, actualArgs) =
      args.headOption match {
        case Some("-n") =>
          (false, args.drop(1))
        case _ =>
          (true, args)
      }

    actualArgs match {
      case Array(h, t @ _*) =>
        print(h)
        for (w <- t) {
          print(" ")
          print(w)
        }
      case Array() =>
    }

    if (printNewLine)
      println()
  }
}
