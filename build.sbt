name := "AkkaMainAssignment"

version := "1.0"
scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.3" % Test
)
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.2.0-SNAP7" % "test"
libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5" % "test"