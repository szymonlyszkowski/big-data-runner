name := """big-data-runner"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).enablePlugins(SonarRunnerPlugin)

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")
logBuffered := false
parallelExecution in Test := false

scalaVersion := "2.11.7"
resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots", Resolver.jcenterRepo)

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
  "commons-net" % "commons-net" % "3.6",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.storm-enroute" %% "scalameter" % "0.7" % Test
)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.0"
)

sonarRunnerOptions := Seq("-e", "-X")
sonarProperties ++= Map(
  "sonar.host.url" -> "http://127.0.0.1:9000",
  "sonar.jdbc.username" -> "admin",
  "sonar.jdbc.password" -> "admin"
)

fork in run := false