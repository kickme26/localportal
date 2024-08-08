name := "play-java-seed"

organization := "com.iconnect"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.14"

// Enable the Play Java plugin
enablePlugins(PlayJava)

// Define library dependencies
libraryDependencies += "com.google.inject" % "guice" % "5.0.1"
libraryDependencies += guice

// Define custom task and setting key
lazy val gControllerTask = taskKey[Unit]("Simple custom task")
lazy val newSk = settingKey[String]("Setting Key")
lazy val newtk = taskKey[String]("Task Key")

// Custom task logic
gControllerTask := {
  println("Running custom task...")
}

// Setting Key logic (usually used to provide a value)
newSk := {
  "Setting Key Value"
}

// Task Key logic (tasks return values or perform actions)
newtk := {
  println("Task Key")
  "Task Key Result" // Task should return a result
}
