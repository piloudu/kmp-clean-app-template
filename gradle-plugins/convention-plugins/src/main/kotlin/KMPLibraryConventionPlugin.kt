import android.template.gradle.convention.plugins.common.configureAndroid
import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KMPLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      val libs = the<LibrariesForLibs>()
      with(pluginManager) {
        apply(libs.plugins.kotlin.multiplatform.get().pluginId)
        apply(libs.plugins.android.library.get().pluginId)
      }

      extensions.configure<KotlinMultiplatformExtension> {
        androidTarget()
        applyDefaultHierarchyTemplate()

        with(sourceSets) {
          listOf(iosMain, iosTest, androidMain).forEach { it.get().dependsOn(sourceSets.commonMain.get()) }
        }
      }

      extensions.configure<LibraryExtension> {
        this@with.configureAndroid(this)
        defaultConfig.consumerProguardFile("consumer-rules.pro")
      }
    }
  }
}