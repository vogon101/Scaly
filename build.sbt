lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.freddieposer",
  scalaVersion := "2.13.3",
)

libraryDependencies += "org.scalameta" %% "scalameta" % "4.4.0"
libraryDependencies += "com.github.scopt" % "scopt_2.13" % "4.0.1"


lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    assembly / mainClass := Some("com.freddieposer.scaly.application.Compiler"),
    assembly / assemblyJarName := "scaly.jar"
  )
