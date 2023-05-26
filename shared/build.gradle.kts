plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Ktor.client_core)
                implementation(Ktor.client_content_negotiation)
                implementation(Ktor.client_logging)
                implementation(Ktor.serialization_json)
                implementation(OpenAI.openai)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.materialIconsExtended)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation(Kodein.kodein_core)
                api(Moe.precompose)
                api(Moe.precompose_viewmodel)
               // implementation(Firebase.firestore)
              //  implementation(Firebase.database)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.client_logging_jvm)
                implementation(Ktor.client_json_jvm)
                implementation(Ktor.client_android)
                implementation(compose.preview)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.materialIconsExtended)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation(compose.uiTooling)
                implementation(Kodein.kodein_android)
                implementation(Lottie.lottie)
                implementation(Lottie.lottie_compose)
                implementation(Firebase.auth_android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "com.nst.tales"
    compileSdk = AndroidSdk.compile
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose_compiler
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
