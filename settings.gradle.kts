enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("gradle-plugins")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MultimoduleTemplate"

include(":app")
include(":di")
include(":ui:core")
include(":ui:feature-main")
include(":ui:navigation")
include(":domain")
include(":data:repositories")
include(":data:database")
include(":data:datasource")
include(":testing:core")
include(":testing:test-app")
