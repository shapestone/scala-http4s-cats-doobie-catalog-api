import sbt.addCompilerPlugin

ThisBuild / scalaVersion := "2.13.6"

ThisBuild / version      := "0.1.0"
ThisBuild / organization := "com.shapestone"
ThisBuild / description := "HTTP4S Cats Doobie Scala Template Project"

ThisBuild / scalacOptions ++= Seq(
)

val TypeSafeVersion = "1.4.1"
val ScalaTestVersion = "3.2.9"
val Http4sVersion = "0.23.1"
val CirceVersion = "0.14.1"
val MunitVersion = "0.7.27"
val LogbackVersion = "1.2.5"
val MunitCatsEffectVersion = "1.0.5"
val ScalaMetaVersion = "20.2.0"

lazy val root = (project in file("."))
  .settings(
    name := "Main",
    libraryDependencies += "com.typesafe"   %  "config"              % TypeSafeVersion,
    libraryDependencies += "org.scalatest"  %% "scalatest"           % ScalaTestVersion       % Test,
    libraryDependencies += "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
    libraryDependencies += "org.http4s"     %% "http4s-blaze-client" % Http4sVersion,
    libraryDependencies += "org.http4s"     %% "http4s-circe"        % Http4sVersion,
    libraryDependencies += "org.http4s"     %% "http4s-dsl"          % Http4sVersion,
    libraryDependencies += "io.circe"       %% "circe-generic"       % CirceVersion,
    libraryDependencies += "org.scalameta"  %% "munit"               % MunitVersion           % Test,
    libraryDependencies += "org.typelevel"  %% "munit-cats-effect-2" % MunitCatsEffectVersion % Test,
    libraryDependencies += "ch.qos.logback" %  "logback-classic"     % LogbackVersion,
    libraryDependencies += "org.scalameta"  %% "svm-subs"            % ScalaMetaVersion,
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.1" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
    testFrameworks += new TestFramework("munit.Framework")
  )
