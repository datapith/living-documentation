import io.datapith.cukedoctor.gradle.plugin.model.Format

plugins {
    java
    id("io.datapith.cukedoctor").version("0.1.0")
}

dependencies {
    testImplementation(libs.cukedoctor)
    testImplementation(libs.bundles.cucumber)
}

cukedoctor {
    //featuresDir.set("TEST")
    //outputFileName.set("documentation")

    format.set(Format.PDF)
}
