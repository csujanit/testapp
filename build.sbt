name := "myprojects"

version := "1.0"

scalaVersion := "2.11.0"

val akkaVersion = "2.4.10"


libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" % "akka-stream_2.11" % "2.4.11"

libraryDependencies += "com.typesafe.akka" % "akka-http-core_2.11" % "10.0.1"

libraryDependencies += "com.typesafe.akka" % "akka-http_2.11" % "10.0.1"

libraryDependencies += "com.typesafe.akka" % "akka-http-jackson_2.11" % "10.0.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val stage = taskKey[Unit]("Stage Task")

val Stage = config("stage")

stage := {
  (packageBin in Compile ).value
  (update in Stage).value.allFiles.foreach( f =>
    if(f.getName.matches("webapp-runner-0+.jar")){
      println("copying" + f.getName)
      IO.copyFile(f,baseDirectory.value/"target"/"webapp-runner.jar")
    }

  )
}