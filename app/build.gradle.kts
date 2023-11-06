@file:Suppress("UnstableApiUsage")

import settings.Settings

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    kotlin("kapt")
}

android {
    namespace = "com.example.f1"
    compileSdk = Settings.compileSdk

    defaultConfig {
        minSdk = Settings.minSdk
        targetSdk = Settings.targetSdk
        applicationId = Settings.applicationId
        versionCode = Settings.versionCode
        versionName = Settings.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_BASE_URL", "\"https://v1.formula-1.api-sports.io/\"")
    }

    buildTypes {
        getByName(Settings.BuildType.debug) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Settings.Proguard.android),
                Settings.Proguard.rules
            )
        }

        getByName(Settings.BuildType.release) {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(Settings.Proguard.android),
                Settings.Proguard.rules
            )
        }
    }
    compileOptions {
        sourceCompatibility = Settings.CompileOptions.javaVersion
        targetCompatibility = Settings.CompileOptions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Settings.CompileOptions.kotlinJvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Settings.CompileOptions.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    androidX()
    compose()
    hilt()
    androidTest()
    test()
    features()
}