name := "tcp-async"

version := "1.0"

scalaVersion := "2.10.2"

resolvers ++= Seq(
"Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
"spray repo" at "http://nightlies.spray.io"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.2.0",
  "com.github.mauricio" %% "mysql-async" % "0.2.6",
  "com.typesafe" % "config" % "1.0.2",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
  "io.spray" % "spray-can" % "1.2-20130912",
  "io.spray" % "spray-http" % "1.2-20130912",
  "io.spray" % "spray-httpx" % "1.2-20130912",
  "io.spray" % "spray-util" % "1.2-20130912",
  "io.spray" % "spray-client" % "1.2-20130912"
)

