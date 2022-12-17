package io.datapith.cukedoctor.gradle.plugin

import io.datapith.cukedoctor.gradle.plugin.model.Format
import io.datapith.cukedoctor.gradle.plugin.model.Position
import org.gradle.api.Project
import javax.inject.Inject

/**
 * Extension object containing all the settings and properties for the for Cukedoctor plugin.
 */
@Suppress("UnnecessaryAbstractClass")
abstract class CukedoctorExtension @Inject constructor(project: Project) {

    private val projectObjects = project.objects

    /**
     * Allow included content to be referenced by an URI
     */
    val allowUriRead = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Disable the AsciiDoc 'data-uri' attribute
     */
    val disableDataUri = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Disable features filtering
     */
    val disableFilter = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Disable minimizable feature sections
     */
    val disableMinimizable = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Disable theme support
     */
    val disableTheme = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Documentation title (first section)
     */
    val documentTitle = projectObjects.property(String::class.java).convention("Living Documentation")

    /**
     * Documentation version
     */
    val docVersion = projectObjects.property(String::class.java)

    /**
     * Directory to start searching (recursively) for cucumber json output
     */
    val featuresDir = projectObjects.property(String::class.java).convention(project.buildDir.absolutePath)

    /**
     * Generated documetation format. Possible values: pdf, html, html5, all
     */
    val format = projectObjects.property(Format::class.java).convention(Format.HTML)

    /**
     * Hide `Features` section
     */
    val hideFeaturesSection = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Hide `Scenario` (and `scenario outline`) keywords
     */
    val hideScenarioKeyword = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Hide `step time` calculation on each step
     */
    val hideStepTime = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Hides `Summary` section
     */
    val hideSummarySection = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Hide 'tags'
     */
    val hideTags = projectObjects.property(Boolean::class.java).convention(false)

    /**
     * Section numbering
     */
    val numbered = projectObjects.property(Boolean::class.java).convention(true)

    /**
    * Directory where documentation will be saved
    */
    val outputDir = projectObjects.property(String::class.java)
        .convention("${project.buildDir.absolutePath}/cukedoctor")

    /**
     * Generated documentation file name
     */
    val outputFileName = projectObjects.property(String::class.java).convention("documentation")

    /**
     * Highlighter for source code rendering
     */
    val sourceHighlighter = projectObjects.property(String::class.java).convention("highlightjs")

    /**
     * Sets the asciidoc stem attribute to the specified interpreter e.g. `latexmath`
     */
    val stem = projectObjects.property(String::class.java)

    /**
     * Table of contents position
     */
    val tocPosition = projectObjects.property(Position::class.java).convention(Position.RIGHT)

}
