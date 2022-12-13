package io.datapith.cukedoctor.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

const val EXTENSION_NAME = "cukedoctor"
const val TASK_NAME = "executeCukedoctor"

class CukedoctorPlugin : Plugin<Project> {

    /**
     * Apply this plugin to the given project
     */
    override fun apply(project: Project) {
        // Create extension for plugin
        val extension = project.extensions.create(EXTENSION_NAME, CukedoctorExtension::class.java, project)

        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME, ExecuteCukedoctor::class.java) {
            it.outputFileName.set(extension.outputFileName)
        }

    }
}
