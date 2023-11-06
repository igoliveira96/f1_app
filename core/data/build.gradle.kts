plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.f1.core.data"
}

dependencies {
    hilt()
    androidTest()
    test()
}