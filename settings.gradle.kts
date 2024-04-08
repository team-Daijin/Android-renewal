pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "knowledgender"
include(":app")
include(":core")
include(":feature")
include(":core:designsystem")
include(":core:testing")
include(":feature:home")
include(":core:domain")
include(":core:common")
include(":core:model")
include(":core:datastore")
include(":core:database")
include(":core:data")
include(":core:network")
