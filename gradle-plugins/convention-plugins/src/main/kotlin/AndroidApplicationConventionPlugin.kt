import android.template.gradle.convention.plugins.common.ENABLE_COMPOSE_COMPILER_REPORTS
import android.template.gradle.convention.plugins.common.configureAndroid
import android.template.gradle.convention.plugins.common.configureCompose
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.the

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.android.application.get().pluginId)
                apply(libs.plugins.kotlin.compiler.convention.get().pluginId)
            }

            extensions.configure<BaseAppModuleExtension> {
                this.configureAndroid(this@with)
                this@with.configureCompose(this, libs)

                defaultConfig {
                    targetSdk = 33
                    versionCode = 1
                    versionName = "1.0"

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildTypes {
                    release {
                        // Enable R8 for release builds
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro",
                        )
                    }
                    debug {
                        // Disable R8 for debug builds
                        isMinifyEnabled = false

                        // Enable Compose Compiler reports for debug builds
                        extra.set(ENABLE_COMPOSE_COMPILER_REPORTS, true)
                    }
                }

                packagingOptions {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
        }
    }
}
