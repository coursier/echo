
import sbt._
import sbt.Keys._

object Publish {

  private def pomStuff = Seq(
    organization := "io.get-coursier",
    licenses := Seq("Apache 2.0" -> url("http://opensource.org/licenses/Apache-2.0")),
    homepage := Some(url("https://github.com/coursier/echo")),
    scmInfo := Some(ScmInfo(
      url("https://github.com/coursier/echo.git"),
      "scm:git:github.com/coursier/echo.git",
      Some("scm:git:git@github.com:coursier/echo.git")
    )),
    pomExtra := {
      <developers>
        <developer>
          <id>alexarchambault</id>
          <name>Alexandre Archambault</name>
          <url>https://github.com/alexarchambault</url>
        </developer>
      </developers>
    }
  )

  lazy val settings = pomStuff

}
