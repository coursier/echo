
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

val scala211 = "2.11.12"

lazy val native = project
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "echo",
    scalaVersion := scala211,
    crossScalaVersions := Seq(scala211),
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
skip.in(publish) := true
