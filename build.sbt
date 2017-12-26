
lazy val echo = project
  .in(file("."))
  .enablePlugins(PackPlugin)
  .settings(
    organization := "io.get-coursier",
    scalacOptions ++= Seq("-feature", "-deprecation"),
    crossPaths := false,
    autoScalaLibrary := false,
    organization := "io.get-coursier",
    scalacOptions ++= Seq("-feature", "-deprecation"),
    Publish.settings
  )

