plugins {
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath(Deps.AGP.googleSecrets)
    }
}

subprojects {
    afterEvaluate {
        (extensions.findByName("android") as? com.android.build.gradle.BaseExtension)?.apply {
            defaultConfig {
                buildConfigField("String", "API_BASE_URL", "\"https://v1.formula-1.api-sports.io/\"")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}