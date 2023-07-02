plugins {
    alias(libs.plugins.custom.library.convention)
}

android {
    namespace = "android.template.di"
}

dependencies {
    // Project dependencies
    implementation(projects.ui.core)
    implementation(projects.ui.featureMymodel)
    implementation(projects.data.repositories)
    implementation(projects.data.database)
    implementation(projects.data.datasource)
    implementation(projects.domain)

    implementation(libs.koin.core)

    testImplementation(libs.koin.test)
    testImplementation(libs.junit)
}
