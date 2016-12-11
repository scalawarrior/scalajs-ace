lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Scala.js Ace"

normalizedName := "scalajs-ace"

version := "0.0.4-SNAPSHOT"

organization := "com.scalawarrior"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.1")

libraryDependencies +=
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Ywarn-unused-import"
)

publishTo := {
  val repoInfo =
    if (version.value.trim.endsWith("SNAPSHOT"))
      ("amateras snapshots" -> "/home/groups/a/am/amateras/htdocs/mvn-snapshot/")
    else
      ("amateras releases" -> "/home/groups/a/am/amateras/htdocs/mvn/")
  Some(Resolver.ssh(
    repoInfo._1,
    "shell.sourceforge.jp",
    repoInfo._2) as(System.getProperty("user.name"), (Path.userHome / ".ssh" / "id_rsa").asFile) withPermissions("0664"))
}
