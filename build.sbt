name := "actor-fiddle"

version := "1.0"

scalaVersion := "2.10.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.1.2"

libraryDependencies += "com.typesafe.akka" % "akka-remote_2.10" % "2.1.2"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
