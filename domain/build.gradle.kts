plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // Library dependencies
                implementation(libs.kotlinx.coroutines.common)
                implementation(libs.koin.core)
            }
        }
    }
}
