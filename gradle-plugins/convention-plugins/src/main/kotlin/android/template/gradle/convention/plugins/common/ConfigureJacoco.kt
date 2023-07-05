package android.template.gradle.convention.plugins.common

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

fun Project.configureJacoco(
    libs: LibrariesForLibs,
) {
    pluginManager.apply(libs.plugins.jacoco.get().pluginId)

    configure<JacocoPluginExtension> {
        toolVersion = libs.versions.jacoco.get().toString()
    }

    tasks.register<JacocoReport>("jacocoTestReport") {
        reports {
            xml.required.set(true)
            html.required.set(true)
        }

        classDirectories.setFrom(
            fileTree("$buildDir/tmp/kotlin-classes/"),
        )

        sourceDirectories.setFrom(
            files(
                "$projectDir/src/main/java",
                "$projectDir/src/main/kotlin",
            ),
        )
        executionData.setFrom(file("$buildDir/jacoco/jacocoTestReport.exec"))
    }
}
