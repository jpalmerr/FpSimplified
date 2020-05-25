name := "FpSimplified"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.1.1",
  "org.typelevel" %% "cats-effect" % "2.1.3",
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation"
)
