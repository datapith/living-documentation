plugins {
    java
    id("io.datapith.cukedoctor")
}

dependencies {
    //testImplementation(libs.cukedoctor)
    testImplementation(libs.bundles.cucumber)
}

cukedoctor {
    //featuresDir.set("TEST")
    //outputFileName.set("documentation")

    //format.set(Format.PDF)
}
