plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.f1.core.database"
}

dependencies {
    coreDatabase()
}

kapt {
    correctErrorTypes = true
}