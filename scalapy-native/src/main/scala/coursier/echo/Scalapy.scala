package coursier.echo

import me.shadaj.scalapy.echo.Helper
import me.shadaj.scalapy.interpreter.CPythonInterpreter
import me.shadaj.scalapy.py

object Scalapy {
  def main(args: Array[String]): Unit = {
    py.local {
      val args0 = args.toSeq.map(x => x: py.Any)
      // Getting "applyDynamic does not support passing a vararg parameter" with
      //   py.Dynamic.global.print(args0: _*)
      // Using @kiendang's suggestion instead (https://gitter.im/shadaj/scalapy?at=6324a9ef72ad51741fe3afb5)
      py.Dynamic.global.applyDynamicNamed("print")(args0.map("" -> _) ++ Seq("flush" -> py.Any.from(true)): _*)

      ()
    }
  }
}
