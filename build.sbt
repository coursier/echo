
lazy val jvm = project
  .enablePlugins(PackPlugin)
  .settings(
    crossPaths := false,
    autoScalaLibrary := false,
    name := "echo",
    Publish.settings
  )

lazy val native = project
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "echo",
    scalaVersion := "2.11.12",
    scalacOptions ++= Seq("-feature", "-deprecation"),
    Publish.settings
  )

lazy val echo = project
  .in(file("."))
  .aggregate(
    jvm,
    native
  )
  .settings(
    publishArtifact := false,
    Publish.settings // seems required for sbt publish to be fine…
  )
