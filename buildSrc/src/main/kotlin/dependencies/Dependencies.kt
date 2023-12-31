import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Versions {

    val coreKtx = "1.8.0"

    object Android {
        val composeBOM = "2022.10.00"
        val activityCompose = "1.5.1"
        val lifecycle = "2.3.1"
    }

    object Test {
        val junit = "4.13.2"
        val androidJunit = "1.1.3"
        val espressoCore = "3.5.1"
    }

    object External {
        val coil = "2.4.0"
    }

}

object Deps {

    object Android {
        val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        val composeBom = "androidx.compose:compose-bom:${Versions.Android.composeBOM}"
        val composeUI = "androidx.compose.ui:ui"
        val composeUIGraphics = "androidx.compose.ui:ui-graphics"
        val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        val composeMaterial3 = "androidx.compose.material3:material3"
        val activityCompose = "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
        val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.lifecycle}"
    }

    object Test {
        val junit = "junit:junit:${Versions.Test.junit}"
        val androidJunit = "androidx.test.ext:junit:${Versions.Test.androidJunit}"
        val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}"
        val composeJunit4 = "androidx.compose.ui:ui-test-junit4"
    }

    object Debug {
        val composeUITooling = "androidx.compose.ui:ui-tooling"
        val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object External {
        val coil = "io.coil-kt:coil-compose:${Versions.External.coil}"
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
    implementation(platform(Deps.Android.composeBom))
    implementation(Deps.Android.composeUI)
    implementation(Deps.Android.composeUIGraphics)
    implementation(Deps.Android.composeToolingPreview)
    implementation(Deps.Android.composeMaterial3)
    implementation(Deps.Android.activityCompose)
    implementation(Deps.External.coil)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Deps.Test.androidJunit)
    androidTestImplementation(Deps.Test.espressoCore)
    androidTestImplementation(platform(Deps.Android.composeBom))
    androidTestImplementation(Deps.Test.composeJunit4)
    debugImplementation(Deps.Debug.composeUITooling)
    debugImplementation(Deps.Debug.composeUITestManifest)
}

fun DependencyHandler.test() {
    testImplementation(Deps.Test.junit)
}

fun DependencyHandler.coreUI() {
    compose()
    androidTest()
    test()
}

fun DependencyHandler.features() {
//    implementation(project(Deps.Modules.Core.ui))
}