plugins {
    alias(libs.plugins.custom.application.convention)
    alias(libs.plugins.custom.ksp.convention)
}

dependencies {
    implementation(projects.ui.core)
    implementation(projects.ui.featureMain)
    implementation(projects.ui.navigation)
    implementation(projects.di)
    implementation(projects.domain)
    implementation(projects.data.datasource)
    testImplementation(projects.testing.core)
    // TODO: Fix cyclic dependency
//    implementation(projects.testApp)

    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Koin Dependency Injection
    implementation(libs.koin.compose)

    // Tracing
    implementation(libs.androidx.compose.runtime.tracing)

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
    implementation(libs.kotlinx.collections.immutable)

    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Koin Test
    testImplementation(libs.koin.test)

    // Local tests: jUnit, coroutines, Android runner
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)

    // For testing flows
    testImplementation(libs.square.cashapp.turbine)
}
