package io.datapith.cukedoctor.gradle.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Property
import javax.inject.Inject

/**
 * Extension object containing all the settings and properties for the for Cukedoctor plugin.
 */
@Suppress("UnnecessaryAbstractClass")
abstract class CukedoctorExtension @Inject constructor(project: Project) {

    private val projectObjects = project.objects

    val outputFileName: Property<String> = projectObjects.property(String::class.java)
}
