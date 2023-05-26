plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Version.gradle).apply(false)
    id("com.android.library").version(Version.gradle).apply(false)
    kotlin("android").version(Version.kotlin).apply(false)
    kotlin("multiplatform").version(Version.kotlin).apply(false)
    id("org.jetbrains.compose").version(Version.compose).apply(false)
    id("com.google.gms.google-services").version(Version.play_services).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
