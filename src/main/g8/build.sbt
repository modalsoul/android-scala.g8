import android.Keys._

name := "$name$"

organization := "$organization$"

version := "$version$"

scalaVersion := "$scala_version$"

incOptions := incOptions.value.withNameHashing(true)

resolvers ++= Seq(
  "Sonatype Repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.scaloid" %% "scaloid" % "4.0"
)

platformTarget in Android := "android-$android_target$"

proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
  , "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
)

run <<= run in Android

android.Plugin.androidBuild

useProguard in Android := false

useProguardInDebug in Android := false

proguardScala in Android := false

dexMulti in Android := true

dexMinimizeMainFile in Android := true

dexMainFileClasses in Android := Seq(
  "com/example/app/MultidexApplication.class",
  "android/support/multidex/BuildConfig.class",
  "android/support/multidex/MultiDex\$V14.class",
  "android/support/multidex/MultiDex\$V19.class",
  "android/support/multidex/MultiDex\$V4.class",
  "android/support/multidex/MultiDex.class",
  "android/support/multidex/MultiDexApplication.class",
  "android/support/multidex/MultiDexExtractor\$1.class",
  "android/support/multidex/MultiDexExtractor.class",
  "android/support/multidex/ZipUtil\$CentralDirectory.class",
  "android/support/multidex/ZipUtil.class"
)


apkbuildExcludes in Android ++= Seq(
  "META-INF/MANIFEST.MF",
  "META-INF/LICENSE.txt",
  "META-INF/LICENSE",
  "META-INF/NOTICE.txt",
  "META-INF/NOTICE"
)

javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")
