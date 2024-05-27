import android.template.gradle.convention.plugins.common.configureCompose
import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()
            with(pluginManager) {
                apply(libs.plugins.custom.library.convention.get().pluginId)
                apply(libs.plugins.compose.compiler.get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                this@with.configureCompose(this, libs)
            }
        }
    }
}
