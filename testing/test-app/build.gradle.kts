plugins {
    alias(libs.plugins.test.convention)
    alias(libs.plugins.kotlin.android)
}

dependencies {
    implementation(projects.data.repositories)
    implementation(projects.testing.core)
    implementation(projects.ui.featureMain)

    // Testing
    implementation(libs.androidx.test.core)

    // Koin tests.
    implementation(libs.koin.test)

    // Compose
    implementation(libs.androidx.compose.ui.test.junit4)
}
