include(
    "plugins:cukedoctor",
    "example"
)

val cucumberVersion: String by settings
val cukedoctorVersion: String by settings
val detektPluginVersion: String by settings
val junitVersion: String by settings
val mockkVersion: String by settings

enableFeaturePreview("VERSION_CATALOGS")

with(rootProject) {
    name = "Living Documentation"
}

pluginManagement {
    val kotlinVersion: String by settings
    val detektPluginVersion: String by settings
    val pluginPublishVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion

        // Plugin quality check code
        id("io.gitlab.arturbosch.detekt").version(detektPluginVersion)

        id("com.gradle.plugin-publish").version(pluginPublishVersion)
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

}


dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            library("cucumber.java", "io.cucumber:cucumber-java:$cucumberVersion")
            library("cucumber.junit", "io.cucumber:cucumber-junit:$cucumberVersion")
            bundle("cucumber", listOf("cucumber.java", "cucumber.junit", "junit.vintage-engine"))

            library("cukedoctor", "com.github.cukedoctor:cukedoctor:$cukedoctorVersion")
            library("cukedoctor.converter", "com.github.cukedoctor:cukedoctor-converter:$cukedoctorVersion")


            library(
                "detekt.formatting",
                "io.gitlab.arturbosch.detekt:detekt-formatting:$detektPluginVersion"
            )

            library("junit.api", "org.junit.jupiter:junit-jupiter-api:$junitVersion")
            library("junit.engine", "org.junit.jupiter:junit-jupiter-engine:$junitVersion")
            library("junit.vintage-engine", "org.junit.vintage:junit-vintage-engine:$junitVersion")

            library("mockk", "io.mockk:mockk:$mockkVersion")
        }
    }
}
