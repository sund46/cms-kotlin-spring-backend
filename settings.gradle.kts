pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        gradlePluginPortal()
    }

    val kotlinVersion : String by settings
    val springBootVersion : String by settings
    val springDependencyManagementVersion : String by settings

    resolutionStrategy{
        eachPlugin{
            when(requested.id.id){
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.jetbrains.kotlin.jvm","org.jetbrains.kotlin.plugin.spring","org.jetbrains.kotlin.plugin.jpa","org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
            }
        }
    }
}

rootProject.name = "cms"
