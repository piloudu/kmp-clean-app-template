plugins {
    alias(libs.plugins.custom.library.convention)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization)

    // Api
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.utils)
    // Engine required for each platform
    implementation(libs.ktor.client.okhttp)
    implementation(libs.square.okhttp)

    // Local tests: jUnit, coroutines
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
