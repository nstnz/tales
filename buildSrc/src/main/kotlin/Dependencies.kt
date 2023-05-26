object Version {
    const val kotlin = "1.7.20"
    const val gradle = "7.3.1"
    const val appcompat = "1.4.0"
    const val material = "1.4.0"
    const val compose = "1.2.1"
    const val compose_compiler = "1.3.2"
    const val precompose = "1.4.0"
    const val ktor = "2.1.2"
    const val kodein = "7.16.0"
    const val mokoMvvm = "0.13.0"
    const val sqlDelightVersion = "1.5.3"
    const val prefs = "0.0.1"
    const val openai = "3.2.4"
    const val activity_compose = "1.7.1"
    const val lottie = "6.0.0"
    const val firebase = "1.8.0"
    const val play_services = "4.3.15"
}

object AndroidSdk {
    const val min = 24
    const val compile = 33
    const val target = compile
}

object iOSSdk {
    const val deploymentTarget = "10.0"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
}

object Compose {
    const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
    const val ui = "androidx.compose.ui:ui:${Version.compose}"
    const val ui_tooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Version.compose}"
    const val material = "androidx.compose.material:material:${Version.compose}"
    const val activity_compose = "androidx.activity:activity-compose:${Version.activity_compose}"
}

object Kotlin {
    const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
}

object Moe {
    const val precompose = "moe.tlaster:precompose:${Version.precompose}"
    const val precompose_viewmodel = "moe.tlaster:precompose-viewmodel:${Version.precompose}"
}

object Ktor {
    const val client_core = "io.ktor:ktor-client-core:${Version.ktor}"
    const val client_content_negotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
    const val client_logging = "io.ktor:ktor-client-logging:${Version.ktor}"
    const val serialization_json = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
    const val client_logging_jvm = "io.ktor:ktor-client-logging-jvm:${Version.ktor}"
    const val client_json_jvm = "io.ktor:ktor-client-json-jvm:${Version.ktor}"
    const val client_android = "io.ktor:ktor-client-android:${Version.ktor}"
    const val client_ios = "io.ktor:ktor-client-ios:${Version.ktor}"
}

object Kodein {
    const val kodein_core = "org.kodein.di:kodein-di:${Version.kodein}"
    const val kodein_android = "org.kodein.di:kodein-di-framework-android-x:${Version.kodein}"
}

object Prefs {
    const val prefs = "de.gal-digital:kmm-preferences:${Version.prefs}"
}

object SqlDelight {
    const val sql_runtime = "com.squareup.sqldelight:runtime:${Version.sqlDelightVersion}"
    const val sql_android = "com.squareup.sqldelight:android-driver:${Version.sqlDelightVersion}"
    const val sql_ios = "com.squareup.sqldelight:native-driver:${Version.sqlDelightVersion}"
}

object Moko {
    const val moko_core = "dev.icerock.moko:mvvm-core:${Version.mokoMvvm}"
    const val moko_flow = "dev.icerock.moko:mvvm-flow:${Version.mokoMvvm}"
    const val moko_flow_compose = "dev.icerock.moko:mvvm-flow-compose:${Version.mokoMvvm}"
}

object OpenAI {
    const val openai = "com.aallam.openai:openai-client:${Version.openai}"
}

object Lottie {
    const val lottie = "com.airbnb.android:lottie:${Version.lottie}"
    const val lottie_compose = "com.airbnb.android:lottie-compose:${Version.lottie}"
}

object Firebase {
    const val auth = "dev.gitlive:firebase-auth::${Version.firebase}"
    const val database = "dev.gitlive:firebase-database:${Version.firebase}"
    const val firestore = "dev.gitlive:firebase-firestore:${Version.firebase}"
}
