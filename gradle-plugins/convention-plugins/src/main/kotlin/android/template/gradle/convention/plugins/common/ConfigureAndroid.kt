package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.configureAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    val libs = the<LibrariesForLibs>()

    val projectName = if (parent!!.name != rootProject.name) {
        "%s.%s".format(
            parent!!.name,
            name,
        )
    } else {
        name
    }

    commonExtension.namespace = "android.template.${projectName.replace("-", ".")}"
    commonExtension.compileSdk = 34
    commonExtension.defaultConfig.minSdk = 26

    commonExtension.buildFeatures {
        this.aidl = false
        this.buildConfig = false
        this.renderScript = false
        this.shaders = false
    }

    commonExtension.compileOptions {
        this.sourceCompatibility = JavaVersion.VERSION_17
        this.targetCompatibility = JavaVersion.VERSION_17
    }

    configureJacoco(libs)
}
