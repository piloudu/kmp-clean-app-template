import android.template.gradle.convention.plugins.common.configureAndroid
import com.android.build.gradle.TestExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.android.test.get().pluginId)
                apply(libs.plugins.kotlin.compiler.convention.get().pluginId)
            }

            extensions.configure<TestExtension> {
                this.configureAndroid(this@with)
                targetProjectPath = ":app"

                defaultConfig {
                    targetSdk = 33
                }
            }
        }
    }
}
