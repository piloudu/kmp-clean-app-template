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
        register("androidTestConvention") {
            id = "android.template.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("kotlinCompilerConvention") {
            id = "android.template.kotlin.compiler"
            implementationClass = "KotlinCompilerConventionPlugin"
        }
        register("androidApplicationConvention") {
            id = "android.template.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
