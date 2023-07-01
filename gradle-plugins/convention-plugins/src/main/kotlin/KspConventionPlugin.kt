import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

class KspConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.ksp.get().pluginId)
            }

            extensions.configure<KspExtension> {
                // Enable room auto-migrations
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }
}
