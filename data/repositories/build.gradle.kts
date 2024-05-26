plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // Koin Dependency Injection
                implementation(libs.koin.core)

                implementation(libs.kotlinx.coroutines.common)
            }
        }
        commonTest {
            dependencies {
                // Local tests: jUnit, coroutines, Android runner
                implementation(libs.junit)
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}

dependencies {
    // Project dependencies
    implementation(projects.data.database)
    implementation(projects.data.datasource)
    implementation(projects.domain)
    implementation(projects.ui.core)
}