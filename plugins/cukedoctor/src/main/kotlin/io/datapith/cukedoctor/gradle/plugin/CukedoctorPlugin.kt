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
            it.allowUriRead.set((extension.allowUriRead))
            it.disableDataUri.set(extension.disableDataUri)
            it.disableFilter.set(extension.disableFilter)
            it.disableMinimizable.set(extension.disableMinimizable)
            it.disableTheme.set(extension.disableTheme)
            it.documentTitle.set(extension.documentTitle)
            it.docVersion.set(extension.docVersion)
            it.featuresDir.set(extension.featuresDir)
            it.format.set(extension.format)
            it.hideFeaturesSection.set(extension.hideFeaturesSection)
            it.hideScenarioKeyword.set(extension.hideScenarioKeyword)
            it.hideStepTime.set(extension.hideStepTime)
            it.hideSummarySection.set(extension.hideSummarySection)
            it.hideTags.set(extension.hideTags)
            it.numbered.set(extension.numbered)
            it.outputDir.set(extension.outputDir)
            it.outputFileName.set(extension.outputFileName)
            it.sourceHighlighter.set(extension.sourceHighlighter)
            it.stem.set(extension.stem)
            it.tocPosition.set(extension.tocPosition)
         }

    }
}
