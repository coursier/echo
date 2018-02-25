
lazy val echo = project
  .in(file("."))
  .enablePlugins(SbtProguard)
  .settings(
    name := "echo",
    version := "1.0.2-SNAPSHOT",
    scalaVersion := "2.12.4",
    scalacOptions ++= Seq("-feature", "-deprecation"),
    Publish.settings,
    proguardOptions.in(Proguard) ++= Seq(
      // "-dontoptimize", // uncomment to make it work (but it doesn't really proguard then…)
      "-dontobfuscate",
      "-dontnote",
      "-dontwarn",
      "-ignorewarnings",
      ProguardOptions.keepMain("coursier.echo.Echo")
    ),
    proguardInputFilter.in(Proguard) := { file =>
      file.name match {
        case n if n.contains("echo") => None
        case n => Some("!META-INF/**")
      }
    }
  )

