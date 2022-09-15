package me.shadaj.scalapy.echo

import me.shadaj.scalapy.py
import me.shadaj.scalapy.interpreter.PyValue

object Helper {
  def scalapyValue(v: py.Any): PyValue =
    v.__scalapy_value
}
