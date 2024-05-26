plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // Library dependencies
                implementation(libs.kotlinx.coroutines.common)
                implementation(libs.koin.core)
                implementation(libs.kotlinx.serialization)
            }
        }
    }
}
