import Dependencies.*

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "apprentissage-spark",
    libraryDependencies := List(
      "org.apache.spark" %% "spark-core" % Version.spark,
      "org.apache.spark" %% "spark-sql" % Version.spark,
    )
  )
