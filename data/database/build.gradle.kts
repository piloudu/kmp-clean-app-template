plugins {
    alias(libs.plugins.custom.library.convention)
    alias(libs.plugins.custom.ksp.convention)
}

dependencies {
    // Arch Components
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Koin Dependency Injection
    implementation(libs.koin.android)
}
