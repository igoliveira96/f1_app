package settings

import org.gradle.api.JavaVersion

object Settings {

    val compileSdk = 33
    val applicationId = "com.example.f1"
    val minSdk = 24
    val targetSdk = 33
    val versionCode = 1
    val versionName = "1.0"
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object Proguard {
        val android = "proguard-android-optimize.txt"
        val rules = "proguard-rules.pro"
    }

    object BuildType {
        const val debug = "debug"
        const val release = "release"
    }

    object CompileOptions {
        const val kotlinJvmTarget = "18"
        const val kotlinCompilerExtensionVersion = "1.4.2"
        val javaVersion = JavaVersion.VERSION_18
    }

}