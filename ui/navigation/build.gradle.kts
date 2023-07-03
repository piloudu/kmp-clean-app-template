plugins {
    alias(libs.plugins.custom.library.with.compose.convention)
}

dependencies {
    // Project dependencies
    implementation(projects.ui.core)
    implementation(projects.ui.featureMain)

    // Compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.navigation.compose)
}
