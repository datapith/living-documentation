package io.datapith.cukedoctor.gradle.plugin

import com.github.cukedoctor.Cukedoctor
import com.github.cukedoctor.api.model.Feature
import com.github.cukedoctor.config.GlobalConfig
import com.github.cukedoctor.parser.FeatureParser
import com.github.cukedoctor.util.FileUtil
import io.datapith.cukedoctor.gradle.plugin.model.Format
import io.datapith.cukedoctor.gradle.plugin.model.Position
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.nio.file.Paths
import java.util.*
import kotlin.io.path.absolutePathString

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

    @get:Input
    @get:Option(option = "chapterLabel", description = "prefix for chapter tables")
    abstract val chapterLabel : Property<String>

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
     * Normally when we write a paragraph in Asciidoc markup the line breaks are not preserved. Multiple lines are
     * combined into a paragraph until an empty line is found to separate paragraphs. If we want to keep line breaks
     * we must add the plus sign (+) at the end of the line. To simulate the same behavior we can also set the
     * `hardbreaks` option to true
     */
    @get:Input
    @get:Option(option = "hardBreaks", description = "Preserve hard breaks in paragraphs")
    abstract val hardBreaks: Property<Boolean>

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
     * External directory containing file named `cukedoctor-intro.adoc`. If such file is found the content of the
     * file will be placed between Documentation title and summary section.
     */
    @get:Input
    @get:Option(
        option = "introChapterDir",
        description = "External directory containing file named `cukedoctor-intro.adoc`")
    @get:Optional
    abstract val introChapterDir :Property<String>

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

    @get:Input
    @get:Option(
        option = "versionLabel",
        description = "Controls the version label displayed before the revision number in the byline")
    abstract val versionLabel : Property<String>

    @TaskAction
    fun execute() {
        // Configure system properties cukedoctor
        if (introChapterDir.isPresent) {
            System.setProperty("INTRO_CHAPTER_DIR", introChapterDir.get())
        }
        System.setProperty("HIDE_FEATURES_SECTION", hideFeaturesSection.get().toString())
        System.setProperty("HIDE_SUMMARY_SECTION", hideSummarySection.get().toString())
        System.setProperty("HIDE_SCENARIO_KEYWORD", hideScenarioKeyword.get().toString())
        System.setProperty("HIDE_STEP_TIME", hideStepTime.get().toString())
        System.setProperty("HIDE_TAGS", hideTags.get().toString())

        logger.info("Searching cucumber features in path: ${featuresDir.get()}")
        val featuresFound: List<Feature> = FeatureParser.findAndParse(featuresDir.get())
        if (featuresFound.isEmpty()) {
            // Couldn't find any feature file so stop execution of task
            logger.warn("No cucumber json files found in ${featuresDir.get()}")
            return
        } else {
           logger.info("Generating living documentation for ${featuresFound.size} feature(s)...")
        }

        val documentAttributes = GlobalConfig.newInstance()
            .documentAttributes
            .allowUriRead(allowUriRead.get())
            .dataUri(!disableDataUri.get())
            .docTitle(documentTitle.get())
            .backend(format.get().name.lowercase(Locale.getDefault()))
            .toc(tocPosition.get().name.lowercase(Locale.getDefault()))
            .revNumber(docVersion.get())
            .hardBreaks(hardBreaks.get())
            .numbered(numbered.get())
            .chapterLabel(chapterLabel.get())
            .versionLabel(versionLabel.get())
//            .stem(stem)

        val converter = Cukedoctor.instance(featuresFound, documentAttributes)
        val targetFile: String
        if (outputFileName.get().contains(".")) {
            targetFile = outputFileName.get().substring(0, outputFileName.get().lastIndexOf(".")) + ".adoc"
        } else {
            targetFile = outputFileName.get() + ".adoc"
        }

        val targetDir: String = outputDir.get()
        val pathToSave = Paths.get(targetDir,targetFile).absolutePathString()
        converter.setFilename(pathToSave) // needed by docinfo, pdf-theme

        val generatedFile = converter.renderDocumentation()
        FileUtil.saveFile(pathToSave, generatedFile)

    }
}
