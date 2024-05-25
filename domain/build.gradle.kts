plugins {
    alias(libs.plugins.custom.kotlin.multiplatform.library.convention)
}

dependencies {
    // Library dependencies
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.core)
}
