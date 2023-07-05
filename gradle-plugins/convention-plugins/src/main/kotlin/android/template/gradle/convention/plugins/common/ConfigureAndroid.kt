package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun CommonExtension<*, *, *, *>.configureAndroid(project: Project) {
    val libs = project.the<LibrariesForLibs>()

    val projectName = if (project.parent!!.name != project.rootProject.name) {
        "%s.%s".format(
            project.parent!!.name,
            project.name,
        )
    } else {
        project.name
    }

    namespace = "android.template.${projectName.replace("-", ".")}"
    compileSdk = 33
    defaultConfig.minSdk = 26

    buildFeatures {
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    project.configureJacoco(libs)
}
