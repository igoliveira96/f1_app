import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {

    const val coreKtx = "1.8.0"

    object Android {
        const val compose = "1.4.2"
        const val activityCompose = "1.5.1"
        const val composeNavigation = "2.5.3"
        const val lifecycleViewModel = ""
        const val material3 = "1.1.2"
        const val lifecycle = "2.3.1"
        const val hilt = "2.48.1"
    }

    object Google {
        const val secrets = "2.0.1"
        const val gson = "2.10.1"
    }

    object Test {
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espressoCore = "3.5.1"
        const val googleTruth = "1.1.5"
    }

    object External {
        const val coil = "2.4.0"
        const val retrofit = "2.9.0"
        const val okhttp3 = "4.11.0"
        const val chucker = "4.0.0"
        const val mockwebserver = "4.11.0"
        const val javapoet = "1.13.0"
        const val coroutines = "1.3.9"
    }

}

object Deps {

    object Android {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val composeUI = "androidx.compose.ui:ui:${Versions.Android.compose}"
        const val composeUIGraphics = "androidx.compose.ui:ui-graphics:${Versions.Android.compose}"
        const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Android.compose}"
        const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.Android.material3}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.Android.compose}"
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.Android.composeNavigation}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycleViewModel}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.lifecycle}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Android.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Android.hilt}"
        const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Android.hilt}"
    }

    object AGP {
        const val googleSecrets = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.Google.secrets}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val androidJunit = "androidx.test.ext:junit:${Versions.Test.androidJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}"
        const val composeJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.Android.compose}"
        const val googleTruth = "com.google.truth:truth:${Versions.Test.googleTruth}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.External.coroutines}"
    }

    object Debug {
        const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.Android.compose}"
        const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.Android.compose}"
    }

    object External {
        const val coil = "io.coil-kt:coil-compose:${Versions.External.coil}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.External.retrofit}"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.External.okhttp3}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.External.okhttp3}"
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.External.chucker}"
        const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.External.chucker}"
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.External.mockwebserver}"
        const val gson = "com.google.code.gson:gson:${Versions.Google.gson}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.External.retrofit}"
        const val javapoet = "com.squareup:javapoet:${Versions.External.javapoet}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.External.coroutines}"
    }

    object Modules {
        object Core {
            const val ui = ":core:ui"
            const val data = ":core:data"
            const val navigation = ":core:navigation"
        }

        object Data {
            const val circuits = ":data:circuits"
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
    implementation(Deps.Android.materialIconsExtended)
    implementation(Deps.Android.composeNavigation)
    implementation(Deps.Android.activityCompose)
    implementation(Deps.External.coil)
    implementation(Deps.Android.lifecycleViewModel)
}

fun DependencyHandler.hilt() {
    implementation(Deps.Android.hiltAndroid)
    kapt(Deps.Android.hiltCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Deps.External.retrofit)
    implementation(Deps.External.okhttp3)
    implementation(Deps.External.loggingInterceptor)
    implementation(Deps.External.gson)
    implementation(Deps.External.gsonConverter)
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
    testImplementation(Deps.Test.coroutines)
}

fun DependencyHandler.coreUI() {
    hilt()
    compose()
    androidTest()
    test()
}

fun DependencyHandler.features() {
    implementationProject(Deps.Modules.Core.ui)
    implementationProject(Deps.Modules.Core.navigation)
    implementationProject(Deps.Modules.Data.circuits)
}

fun DependencyHandler.coreData() {
    hilt()
    retrofit()
    androidTest()
    test()
    implementation(Deps.External.coroutines)
}

fun DependencyHandler.coreNavigation() {
    hilt()
    compose()
    retrofit()
    androidTest()
    test()
}

fun DependencyHandler.dataCircuits() {
    hilt()
    compose()
    retrofit()
    androidTest()
    test()

    implementation(Deps.External.coroutines)

    implementationProject(Deps.Modules.Core.ui)
    implementationProject(Deps.Modules.Core.data)
}