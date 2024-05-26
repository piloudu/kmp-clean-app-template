plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                // Project dependencies
                implementation(projects.data.database)
                implementation(projects.data.datasource)
                implementation(projects.ui.core)
            }
        }
        commonMain {
            dependencies {
                // Project dependencies
                implementation(projects.domain)

                // Library dependencies
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.common)
            }
        }
        androidUnitTest {
            dependencies {
                // Local tests: jUnit, coroutines, Android runner
                implementation(libs.junit)
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}