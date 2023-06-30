import com.android.build.gradle.TestExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
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
                compileSdk = 33
                targetProjectPath = ":app"

                defaultConfig {
                    minSdk = 21
                    targetSdk = 33
                }

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
        }
    }
}
