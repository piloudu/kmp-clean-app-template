plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // Library dependencies
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.koin.core)
            }
        }
    }
}
