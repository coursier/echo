package coursier.echo

import me.shadaj.scalapy.echo.Helper
import me.shadaj.scalapy.interpreter.CPythonInterpreter
import me.shadaj.scalapy.py

object Scalapy {
  def main(args: Array[String]): Unit = {
    py.local {
      val args0 = args.toSeq.map(x => x: py.Any)
      // What we really want to do is:
      //   py.Dynamic.global.print(args0: _*)
      // but getting "applyDynamic does not support passing a vararg parameter"
      CPythonInterpreter.callGlobal(
        "print",
        args0.map(Helper.scalapyValue),
        Seq()
      )

      ()
    }
  }
}
