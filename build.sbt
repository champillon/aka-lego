name := """aka-lego"""
organization := "th.pt"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.6"
)
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test