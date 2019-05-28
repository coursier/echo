
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

lazy val native = project
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "echo",
    scalaVersion := "2.11.12",
    scalacOptions ++= Seq("-feature", "-deprecation")
  )

lazy val props = project
  .enablePlugins(PackPlugin)
  .settings(
    crossPaths := false,
    autoScalaLibrary := false,
    name := "props"
  )

lazy val echo = project
  .in(file("."))
  .aggregate(
    jvm,
    native,
    props
  )
  .settings(
    skip.in(publish) := true
  )
