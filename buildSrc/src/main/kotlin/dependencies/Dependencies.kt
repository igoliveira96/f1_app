import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {

    val coreKtx = "1.8.0"

    object Android {
        val compose = "1.4.2"
        val activityCompose = "1.5.1"
        val material3 = "1.1.2"
        val lifecycle = "2.3.1"
        val hilt = "2.44"
    }

    object Google {
        val secrets = "2.0.1"
    }

    object Test {
        val junit = "4.13.2"
        val androidJunit = "1.1.3"
        val espressoCore = "3.5.1"
        val googleTruth = "1.1.5"
    }

    object External {
        val coil = "2.4.0"
        val retrofit = "2.9.0"
        val okhttp3 = "4.11.0"
        val chucker = "4.0.0"
        val mockwebserver = "4.11.0"
    }

}

object Deps {

    object Android {
        val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        val composeUI = "androidx.compose.ui:ui:${Versions.Android.compose}"
        val composeUIGraphics = "androidx.compose.ui:ui-graphics:${Versions.Android.compose}"
        val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Android.compose}"
        val composeMaterial3 = "androidx.compose.material3:material3:${Versions.Android.material3}"
        val activityCompose = "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
        val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.lifecycle}"
        val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Android.hilt}"
        val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Android.hilt}"
        val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Android.hilt}"
    }

    object AGP {
        val googleSecrets = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.Google.secrets}"
    }

    object Test {
        val junit = "junit:junit:${Versions.Test.junit}"
        val androidJunit = "androidx.test.ext:junit:${Versions.Test.androidJunit}"
        val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}"
        val composeJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.Android.compose}"
        val googleTruth = "com.google.truth:truth:${Versions.Test.googleTruth}"
    }

    object Debug {
        val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.Android.compose}"
        val composeUITestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.Android.compose}"
    }

    object External {
        val coil = "io.coil-kt:coil-compose:${Versions.External.coil}"
        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.External.retrofit}"
        val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.External.okhttp3}"
        val chucker = "com.github.chuckerteam.chucker:library:${Versions.External.chucker}"
        val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.External.chucker}"
        val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.External.mockwebserver}"
    }

    object Modules {
        object Core {
            val ui = ":core:ui"
        }
    }

}

fun DependencyHandler.androidX() {
    implementation(Deps.Android.coreKtx)
    implementation(Deps.Android.lifecycle)
}

fun DependencyHandler.compose() {
    implementation(Deps.Android.composeUI)
    implementation(Deps.Android.composeUIGraphics)
    implementation(Deps.Android.composeToolingPreview)
    implementation(Deps.Android.composeMaterial3)
    implementation(Deps.Android.activityCompose)
    implementation(Deps.External.coil)
}

fun DependencyHandler.hilt() {
    implementation(Deps.Android.hiltAndroid)
    kapt(Deps.Android.hiltCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Deps.External.retrofit)
    implementation(Deps.External.okhttp3)
    debugImplementation(Deps.External.chucker)
    releaseImplementation(Deps.External.chuckerNoOp)
    testImplementation(Deps.External.mockwebserver)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Deps.Test.androidJunit)
    androidTestImplementation(Deps.Test.espressoCore)
    androidTestImplementation(Deps.Test.composeJunit4)
    debugImplementation(Deps.Debug.composeUITooling)
    debugImplementation(Deps.Debug.composeUITestManifest)
}

fun DependencyHandler.test() {
    implementation(Deps.Test.junit)
    implementation(Deps.Test.googleTruth)
}

fun DependencyHandler.coreUI() {
    compose()
    androidTest()
    test()
}

fun DependencyHandler.features() {
//    implementation(project(Deps.Modules.Core.ui))
}