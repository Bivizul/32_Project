import org.jetbrains.compose.compose

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "aaa.bivizul.a32project.android"
    compileSdk = Deps.Versions.compileSdk
    defaultConfig {
        applicationId = "aaa.bivizul.a32project.android"
        minSdk = Deps.Versions.minSdk
        targetSdk = Deps.Versions.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.activityCompose)
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(Deps.JetBrains.Serialization.serializationJson)
    implementation(Deps.ArkIvanov.Decompose.decompose)
    implementation(Deps.ArkIvanov.Decompose.extensionsAndroid)
    implementation(Deps.Kmp.Util.onesignal)
    implementation(Deps.Kmp.Util.advancedWebView)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation(Deps.Kmp.Util.landscapist)

}