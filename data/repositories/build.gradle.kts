plugins {
    alias(libs.plugins.custom.library.convention)
}

dependencies {
    // Project dependencies
    implementation(projects.data.database)
    implementation(projects.data.datasource)
    implementation(projects.domain)
    implementation(projects.ui.core)

    // Koin Dependency Injection
    implementation(libs.koin.core)

    implementation(libs.kotlinx.coroutines.android)

    // Local tests: jUnit, coroutines, Android runner
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
