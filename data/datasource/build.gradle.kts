plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin.sourceSets {
    commonMain {
        dependencies {
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.common)
            implementation(libs.kotlinx.serialization)

            // Api
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.utils)
        }
    }

    androidMain {
        dependencies {
            // Engine required for each platform
            implementation(libs.ktor.client.okhttp)
            implementation(libs.square.okhttp)
        }
    }

    androidUnitTest {
        dependencies {
            implementation(libs.junit)
        }
    }

    commonTest {
        dependencies {
            implementation(libs.kotlinx.coroutines.test)
        }
    }
}

