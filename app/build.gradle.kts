plugins {
    alias(libs.plugins.custom.application.convention)
    alias(libs.plugins.custom.ksp.convention)
}

dependencies {
    implementation(projects.ui.core)
    implementation(projects.ui.featureMain)
    implementation(projects.ui.navigation)
    implementation(projects.di)
    // TODO: Fix cyclic dependency
//    implementation(projects.testApp)

    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Koin Dependency Injection
    implementation(libs.koin.compose)

    // Arch Components
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)

    // Compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
}
