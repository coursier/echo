addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.0")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.0-M2" exclude("org.scala-native", "sbt-crossproject"))
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.11")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")
addSbtPlugin("com.dwijnand" % "sbt-travisci" % "1.2.0")

addSbtCoursier
