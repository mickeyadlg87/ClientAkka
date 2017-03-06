name := "ClientAkka"

version := "1.1"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.1.1",
  "com.typesafe.akka" %% "akka-remote" % "2.1.1"
)