plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.f1.data.circuits"
}

dependencies {
    dataCircuits()
}