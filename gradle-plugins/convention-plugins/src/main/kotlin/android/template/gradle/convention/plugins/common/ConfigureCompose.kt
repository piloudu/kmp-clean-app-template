package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.accessors.dm.LibrariesForLibs

fun CommonExtension<*, *, *, *>.configureCompose(libs: LibrariesForLibs) {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
}
