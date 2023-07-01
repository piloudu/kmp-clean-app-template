import android.template.gradle.convention.plugins.common.configureAndroid
import android.template.gradle.convention.plugins.common.configureCompose
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.android.application.get().pluginId)
                apply(libs.plugins.kotlin.compiler.convention.get().pluginId)
                apply(libs.plugins.ksp.get().pluginId)
            }

            extensions.configure<BaseAppModuleExtension> {
                configureAndroid()
                configureCompose(libs)

                defaultConfig {
                    targetSdk = 33
                    versionCode = 1
                    versionName = "1.0"

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro",
                        )
                    }
                }

                packagingOptions {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }

            extensions.configure<KspExtension> {
                // Enable room auto-migrations
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }
}
