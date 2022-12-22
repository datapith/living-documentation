plugins {
    id("org.asciidoctor.jvm.convert")
}

tasks {
    "asciidoctor"(org.asciidoctor.gradle.jvm.AsciidoctorTask::class) {
        baseDirFollowsSourceDir()
        sources(delegateClosureOf<PatternSet> {
            include("book.adoc")
        })
    }
}
