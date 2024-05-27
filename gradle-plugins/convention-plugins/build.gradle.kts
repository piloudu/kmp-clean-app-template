plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("androidApplicationConvention") {
            id = "android.template.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryConvention") {
            id = "android.template.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("composeConvention") {
            id = "android.template.library.with.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("kotlinCompilerConvention") {
            id = "android.template.kotlin.compiler"
            implementationClass = "KotlinCompilerConventionPlugin"
        }
        register("kspConvention") {
            id = "android.template.ksp"
            implementationClass = "KspConventionPlugin"
        }
        register("androidTestConvention") {
            id = "android.template.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("kotlinMultiplatformLibraryConvention") {
            id = "kotlin.multiplatform.library.convention"
            implementationClass = "KMPLibraryConventionPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
