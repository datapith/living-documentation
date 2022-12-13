val javaVersion: String by project

plugins {
    jacoco
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt")
}

allprojects {
    group = "io.datapith.actors"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin( "jacoco")
        plugin("io.gitlab.arturbosch.detekt")
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion))
        }
    }

    detekt {
        autoCorrect = true
        debug = false
        ignoreFailures = false
        config = files("$rootDir/detekt.yml")
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        detektPlugins(rootProject.libs.detekt.formatting)

        testImplementation(rootProject.libs.junit.api)
        testRuntimeOnly(rootProject.libs.junit.engine)

        testImplementation(rootProject.libs.mockk)
    }

    // Enable JUnit5 testing - default is JUnit4
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test) // tests are required to run before generating the report
        reports {
            xml.required.set(true)
            csv.required.set(false)
            html.required.set(true)
        }
    }
}
