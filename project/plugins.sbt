addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.3.1")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.3.6" exclude("org.scala-native", "sbt-crossproject"))
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.11")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")
addSbtPlugin("com.dwijnand" % "sbt-travisci" % "1.1.1")

addSbtCoursier
