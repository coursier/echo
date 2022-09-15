
inThisBuild(List(
  organization := "io.get-coursier",
  homepage := Some(url("https://github.com/coursier/echo")),
  licenses := Seq("Apache 2.0" -> url("http://opensource.org/licenses/Apache-2.0")),
  developers := List(
    Developer(
      "alexarchambault",
      "Alexandre Archambault",
      "",
      url("https://github.com/alexarchambault")
    )
  )
))

lazy val jvm = project
  .enablePlugins(PackPlugin)
  .settings(
    crossPaths := false,
    autoScalaLibrary := false,
    name := "echo"
  )

val scala213 = "2.13.8"

lazy val native = project
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "echo",
    scalaVersion := scala213,
    crossScalaVersions := Seq(scala213),
    scalacOptions ++= Seq("-feature", "-deprecation")
  )

lazy val env = project
  .enablePlugins(PackPlugin)
  .settings(
    crossPaths := false,
    autoScalaLibrary := false
  )

lazy val props = project
  .enablePlugins(PackPlugin)
  .settings(
    crossPaths := false,
    autoScalaLibrary := false
  )

crossScalaVersions := Nil
(publish / skip) := true
