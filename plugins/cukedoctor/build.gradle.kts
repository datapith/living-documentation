plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    id("com.gradle.plugin-publish")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(gradleApi())
    implementation(libs.cukedoctor.converter)
}

gradlePlugin {
    plugins {
        website.set(property("WEBSITE").toString())
        vcsUrl.set(property("VCS_URL").toString())
        create(property("ID").toString()) {
            id = property("ID").toString()
            implementationClass = property("IMPLEMENTATION_CLASS").toString()
            version = property("VERSION").toString()
            displayName = property("DISPLAY_NAME").toString()
            description = property("DESCRIPTION").toString()
            tags.set(listOf("testing", "integrationTesting", "cucumber", "asciidoc", "documentation", "living-documentation"))
        }
    }
}
