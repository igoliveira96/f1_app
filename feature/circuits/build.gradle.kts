plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.f1.feature.circuits"
}

dependencies {
    featureCircuits()
}