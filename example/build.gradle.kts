plugins {
    java
    id("io.datapith.cukedoctor").version("0.1.0")
}

cukedoctor {
  outputFileName.set("documentation")
}
