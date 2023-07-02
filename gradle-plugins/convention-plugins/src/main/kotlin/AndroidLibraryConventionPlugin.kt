import android.template.gradle.convention.plugins.common.ENABLE_COMPOSE_COMPILER_REPORTS
import android.template.gradle.convention.plugins.common.configureAndroid
import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.the

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.android.library.get().pluginId)
                apply(libs.plugins.kotlin.compiler.convention.get().pluginId)
            }

            extra.set(ENABLE_COMPOSE_COMPILER_REPORTS, true)

            extensions.configure<LibraryExtension> {
                configureAndroid()
                defaultConfig.consumerProguardFile("consumer-rules.pro")
            }
        }
    }
}
