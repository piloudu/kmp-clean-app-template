package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun CommonExtension<*, *, *, *>.configureAndroid(project: Project) {
    val projectName = if (project.parent!!.name != project.rootProject.name) {
        "%s.%s".format(
            project.parent!!.name,
            project.name,
        )
    } else {
        project.name
    }

    namespace = "android.template.$projectName"
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
}
