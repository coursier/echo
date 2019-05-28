addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.0")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.0-M2" exclude("org.scala-native", "sbt-crossproject"))
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.11")
addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.2.6")

addSbtCoursier
