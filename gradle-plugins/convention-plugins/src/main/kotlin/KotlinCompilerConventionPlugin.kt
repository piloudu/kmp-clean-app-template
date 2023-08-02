import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinCompilerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.kotlin.android.get().pluginId)
                apply(libs.plugins.kotlin.parcelize.get().pluginId)
            }

            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                    freeCompilerArgs += listOf("-Xcontext-receivers")
                    languageVersion = "2.0"
                }
            }
        }
    }
}
