plugins { }

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath(Deps.Android.hiltAgp)
        classpath(Deps.AGP.googleSecrets)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}