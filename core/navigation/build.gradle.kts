plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.f1.core.navigation"
}

dependencies {
    coreNavigation()
}