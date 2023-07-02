plugins {
    alias(libs.plugins.custom.library.convention)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.androidx.test.runner)
    implementation(libs.koin.test)
}
