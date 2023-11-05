plugins { }

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Deps.Android.hiltAgp)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}