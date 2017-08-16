name := """aka-lego"""
organization := "th.pt"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice
  , jdbc
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.6"
  , "org.postgresql" % "postgresql" % "9.4.1211"
  , "nb" %% "yoda-orm" % "1.3.0"
)
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test