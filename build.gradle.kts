plugins {
    // Declare the plugins used without applying them in order to register the version
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.library) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
}

// Root build.gradle.kts
