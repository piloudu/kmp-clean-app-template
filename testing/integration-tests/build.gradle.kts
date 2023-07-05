plugins {
    alias(libs.plugins.custom.library.convention)
}

dependencies {
    testImplementation(projects.ui.core)
    testImplementation(projects.ui.featureMain)
    testImplementation(projects.di)
    testImplementation(projects.domain)
    testImplementation(projects.data.datasource)
    testImplementation(projects.testing.core)

    // Koin Test
    testImplementation(libs.koin.test)

    // Local tests: jUnit, coroutines, Android runner
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)

    // For testing flows
    testImplementation(libs.square.cashapp.turbine)
    testImplementation(libs.kotlinx.collections.immutable)
    testImplementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.androidx.lifecycle.viewmodel.compose)
}
