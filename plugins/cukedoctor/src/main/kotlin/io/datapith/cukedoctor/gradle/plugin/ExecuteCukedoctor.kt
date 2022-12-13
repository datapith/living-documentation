package io.datapith.cukedoctor.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.options.Option

@Suppress("UnnecessaryAbstractClass")
abstract class ExecuteCukedoctor : DefaultTask() {

    init {
        description = "Just a sample template task"

        // Don't forget to set the group here.
        // group = BasePlugin.BUILD_GROUP
    }

    @get:Input
    @get:Option(option = "outputFileName", description = "Generated documentation file name")
    abstract val outputFileName: Property<String>

}
