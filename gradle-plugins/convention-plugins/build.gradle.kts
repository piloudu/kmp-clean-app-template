plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("androidLibraryConvention") {
            id = "android.template.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("composeConvention") {
            id = "android.template.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
