plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.nst.tales.android"
    compileSdk = AndroidSdk.compile
    defaultConfig {
        applicationId = "com.nst.tales.android"
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose_compiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Android.appcompat)
    implementation(Android.material)

    implementation(Compose.runtime)
    implementation(Compose.ui)
    implementation(Compose.ui_tooling)
    implementation(Compose.ui_tooling_preview)
    implementation(Compose.foundationLayout)
    implementation(Compose.activity_compose)
    implementation(Compose.material)
    implementation(Prefs.prefs)
    implementation(Moe.precompose)
}