pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Waifu Image"
include(":app")
include(":core:theme")
include(":core:data")
include(":core:domain")
include(":core:remote")
include(":feature:waifu")
include(":core:model")
