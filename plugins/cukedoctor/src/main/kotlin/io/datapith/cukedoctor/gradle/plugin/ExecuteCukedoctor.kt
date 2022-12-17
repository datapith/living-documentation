package io.datapith.cukedoctor.gradle.plugin

import io.datapith.cukedoctor.gradle.plugin.model.Format
import io.datapith.cukedoctor.gradle.plugin.model.Position
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

@Suppress("UnnecessaryAbstractClass")
abstract class ExecuteCukedoctor : DefaultTask() {

    //private val logger = LoggerFactory.getLogger(ExecuteCukedoctor::class.java)

    init {
        description = "Just a sample template task"

        // Don't forget to set the group here.
        // group = BasePlugin.BUILD_GROUP
    }

    /**
     * Allow included content to be referenced by an URI
     */
    @get:Input
    @get:Option(option = "allowUriRead", description = "Allow included content to be referenced by an URI")
    abstract val allowUriRead: Property<Boolean>

    /**
     * Disable the AsciiDoc 'data-uri' attribute
     */
    @get:Input
    @get:Option(option = "disableDataUri", description="Disable the AsciiDoc 'data-uri' attribute")
    abstract val disableDataUri:Property<Boolean>

    /**
     * Disable features filtering
     */
    @get:Input
    @get:Option(option = "disableFilter", description = "Disable features filtering")
    abstract val disableFilter: Property<Boolean>

    /**
     * Disable minimizable feature sections
     */
    @get:Input
    @get:Option(option = "disableMinimizable", description = "Disable minimizable feature sections")
    abstract val disableMinimizable: Property<Boolean>

    /**
     * Disable theme support
     */
    @get:Input
    @get:Option(option = "disableTheme", description = "Disable theme support")
    abstract val disableTheme: Property<Boolean>

    /**
     * Documentation title (first section)
     */
    @get:Input
    @get:Option(option = "documentTile", description = "Documentation title (first section)")
    abstract val documentTitle: Property<String>

    /**
     * Documentation version
     */
    @get:Input
    @get:Option(option = "docVersion", description = "Documentation version")
    abstract val docVersion: Property<String>

    /**
     * Directory to start searching (recursively) for cucumber json output
     */
    @get:Input
    @get:Option(
        option = "featuresDir",
        description = "Directory to start searching (recursively) for cucumber json output"
    )
    abstract val featuresDir: Property<String>

    /**
     * Generated documetation format. Possible values: pdf, html, html5, all
     */
    @get:Input
    @get:Option(
        option = "format",
        description = "Generated documetation format."
    )
    abstract val format: Property<Format>

    /**
     * Hide `Features` section
     */
    @get:Input
    @get:Option(option = "hideFeaturesSection", description = "Hide `Features` section")
    abstract val hideFeaturesSection: Property<Boolean>

    /**
     * Hide `step time` calculation on each step
     */
    @get:Input
    @get:Option(option = "hideStepTime", description = "Hide `step time` calculation on each step")
    abstract val hideStepTime: Property<Boolean>

    /**
     * Hide `Scenario` (and `scenario outline`) keywords
     */
    @get:Input
    @get:Option(option = "hideScenarioKeyword", description = "Hide `Scenario` (and `scenario outline`) keywords")
    abstract val hideScenarioKeyword: Property<Boolean>

    /**
     * Hide 'tags'
     */
    @get:Input
    @get:Option(option = "hideTags", description = " Hide 'tags'")
    abstract val hideTags: Property<Boolean>

    /**
     * Hide `Summary` section
     */
    @get:Input
    @get:Option(option = "hideSummarySection", description = "Hide `Summary` section")
    abstract val hideSummarySection: Property<Boolean>

    /**
     * Section numbering
     */
    @get:Input
    @get:Option(option = "numbered", description = "Section numbering")
    abstract val numbered: Property<Boolean>

    /**
     * Directory where documentation will be saved
     */
    @get:Input
    @get:Option(option = "outputDir", description = "Directory where documentation will be saved")
    abstract val outputDir: Property<String>

    /**
     * Highlighter for source code rendering
     */
    @get:Input
    @get:Option(option = "sourceHighlighter", description = "Highlighter for source code rendering")
    @get:Optional
    abstract val sourceHighlighter: Property<String>

    /**
     * Generated documentation file name
     */
    @get:Input
    @get:Option(option = "outputFileName", description = "Generated documentation file name")
    abstract val outputFileName: Property<String>

    /**
     * Sets the asciidoc stem attribute to the specified interpreter e.g. `latexmath`
     */
    @get:Input
    @get:Option(
        option = "stem",
        description = "Sets the asciidoc stem attribute to the specified interpreter e.g. `latexmath`"
    )
    abstract val stem: Property<String>

    /**
     * Table of contents position
     */
    @get:Input
    @get:Option(option = "tocPosition", description = "Table of contents position")
    abstract val tocPosition: Property<Position>


    @TaskAction
    fun execute() {
        logger.warn("bla $outputFileName")
        println("Received features dir is ${featuresDir.get()}")
        println("Received format is ${format.get()}")
    }
}
