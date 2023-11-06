plugins { }

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Deps.Android.hiltAgp)
        classpath(Deps.AGP.googleSecrets)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}