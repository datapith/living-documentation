include(
    "book",
    "example"
)
includeBuild("plugins")


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
    val asciidoctorPluginVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion

        // Plugin quality check code
        id("io.gitlab.arturbosch.detekt").version(detektPluginVersion)

        id("org.asciidoctor.jvm.convert").version(asciidoctorPluginVersion)
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
