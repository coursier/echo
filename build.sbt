
lazy val echo = project
  .in(file("."))
  .enablePlugins(SbtProguard)
  .settings(
    name := "echo",
    version := "1.0.2-SNAPSHOT",
    scalaVersion := "2.12.4",
    proguardOptions.in(Proguard) ++= Seq(
      // "-dontoptimize", // uncomment to make it work (but it doesn't really proguard then…)
      "-dontobfuscate",
      "-dontnote",
      "-dontwarn",
      "-ignorewarnings",
      ProguardOptions.keepMain("coursier.echo.Echo")
    ),
    proguardInputFilter.in(Proguard) := { _ =>
      Some("!META-INF/**")
    }
  )

