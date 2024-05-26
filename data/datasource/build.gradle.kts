plugins {
    alias(libs.plugins.custom.library.convention)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization)
    implementation(libs.square.retrofit)
    implementation(libs.retrofit.kotlinx.serialization.converter)
    implementation(libs.square.okhttp)

    // Local tests: jUnit, coroutines
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
