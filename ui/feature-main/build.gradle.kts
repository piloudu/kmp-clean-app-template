plugins {
    alias(libs.plugins.custom.library.with.compose.convention)
}

dependencies {
    implementation(projects.domain)
    implementation(projects.ui.core)

    // Core Android dependencies
    implementation(libs.androidx.activity.compose)
    // Arch Components
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Image rendering
    implementation(libs.landscapist.glide)
    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.coil.compose)
    // Tracing
    implementation(libs.androidx.compose.runtime.tracing)
    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Instrumented tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    // Koin Dependency Injection
    implementation(libs.koin.compose)
    // Koin Test
    androidTestImplementation(libs.koin.test)

    /** Testing */
    androidTestImplementation(projects.testing.core)
    testImplementation(projects.testing.core)
    testImplementation(projects.di)
    testImplementation(projects.data.datasource)
    // Koin Test
    testImplementation(libs.koin.test)
    // Local tests: jUnit, coroutines
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    // For testing flows
    testImplementation(libs.square.cashapp.turbine)
    // Instrumented tests: jUnit rules and runners
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
}
