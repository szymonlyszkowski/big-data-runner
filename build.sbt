name := """big-data-runner"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.apache.spark" % "spark-core_2.11" % "2.1.0",
  "org.apache.spark" % "spark-sql_2.11" % "2.1.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.1.0",
  "com.danielasfregola" % "twitter4s_2.11" % "5.0",
  "org.apache.bahir" % "spark-streaming-twitter_2.11" % "2.1.0",
  "org.twitter4j" % "twitter4j" % "4.0.6",
  "com.google.code.gson" % "gson" % "2.4",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.0"
)


fork in run := false