name := "aka-lego"
organization := "th.pt"

version := "1.0.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"
resolvers += "Artifactory Public" at "https://artifact.billme.in.th/artifactory/cache/"

libraryDependencies ++= Seq(
  guice
  , jdbc
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.6"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1"
  , "org.postgresql" % "postgresql" % "9.4.1211"
  , "nb" %% "yoda-orm" % "1.3.0"
)
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test