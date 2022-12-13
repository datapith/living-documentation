package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ArrowLibraryAccessors laccForArrowLibraryAccessors = new ArrowLibraryAccessors(owner);
    private final DetektLibraryAccessors laccForDetektLibraryAccessors = new DetektLibraryAccessors(owner);
    private final JctoolsLibraryAccessors laccForJctoolsLibraryAccessors = new JctoolsLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final LogbackLibraryAccessors laccForLogbackLibraryAccessors = new LogbackLibraryAccessors(owner);
    private final Nd4jLibraryAccessors laccForNd4jLibraryAccessors = new Nd4jLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for mockk (io.mockk:mockk)
         * This dependency was declared in settings file 'settings.gradle.kts'
         */
        public Provider<MinimalExternalModuleDependency> getMockk() { return create("mockk"); }

    /**
     * Returns the group of libraries at arrow
     */
    public ArrowLibraryAccessors getArrow() { return laccForArrowLibraryAccessors; }

    /**
     * Returns the group of libraries at detekt
     */
    public DetektLibraryAccessors getDetekt() { return laccForDetektLibraryAccessors; }

    /**
     * Returns the group of libraries at jctools
     */
    public JctoolsLibraryAccessors getJctools() { return laccForJctoolsLibraryAccessors; }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() { return laccForJunitLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() { return laccForKotlinxLibraryAccessors; }

    /**
     * Returns the group of libraries at logback
     */
    public LogbackLibraryAccessors getLogback() { return laccForLogbackLibraryAccessors; }

    /**
     * Returns the group of libraries at nd4j
     */
    public Nd4jLibraryAccessors getNd4j() { return laccForNd4jLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class ArrowLibraryAccessors extends SubDependencyFactory {

        public ArrowLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.arrow-kt:arrow-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("arrow.core"); }

    }

    public static class DetektLibraryAccessors extends SubDependencyFactory {

        public DetektLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for formatting (io.gitlab.arturbosch.detekt:detekt-formatting)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getFormatting() { return create("detekt.formatting"); }

    }

    public static class JctoolsLibraryAccessors extends SubDependencyFactory {

        public JctoolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jctools:jctools-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("jctools.core"); }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.junit.jupiter:junit-jupiter-api)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("junit.api"); }

            /**
             * Creates a dependency provider for engine (org.junit.jupiter:junit-jupiter-engine)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getEngine() { return create("junit.engine"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for logging (io.github.microutils:kotlin-logging)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getLogging() { return create("kotlin.logging"); }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxBenchmarkLibraryAccessors laccForKotlinxBenchmarkLibraryAccessors = new KotlinxBenchmarkLibraryAccessors(owner);
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.benchmark
         */
        public KotlinxBenchmarkLibraryAccessors getBenchmark() { return laccForKotlinxBenchmarkLibraryAccessors; }

        /**
         * Returns the group of libraries at kotlinx.coroutines
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() { return laccForKotlinxCoroutinesLibraryAccessors; }

        /**
         * Returns the group of libraries at kotlinx.serialization
         */
        public KotlinxSerializationLibraryAccessors getSerialization() { return laccForKotlinxSerializationLibraryAccessors; }

    }

    public static class KotlinxBenchmarkLibraryAccessors extends SubDependencyFactory {
        private final KotlinxBenchmarkRuntimeLibraryAccessors laccForKotlinxBenchmarkRuntimeLibraryAccessors = new KotlinxBenchmarkRuntimeLibraryAccessors(owner);

        public KotlinxBenchmarkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.benchmark.runtime
         */
        public KotlinxBenchmarkRuntimeLibraryAccessors getRuntime() { return laccForKotlinxBenchmarkRuntimeLibraryAccessors; }

    }

    public static class KotlinxBenchmarkRuntimeLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KotlinxBenchmarkRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for runtime (org.jetbrains.kotlinx:kotlinx-benchmark-runtime)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("kotlinx.benchmark.runtime"); }

            /**
             * Creates a dependency provider for jvm (org.jetbrains.kotlinx:kotlinx-benchmark-runtime-jvm)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getJvm() { return create("kotlinx.benchmark.runtime.jvm"); }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("kotlinx.coroutines.core"); }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for cbor (org.jetbrains.kotlinx:kotlinx-serialization-cbor)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getCbor() { return create("kotlinx.serialization.cbor"); }

            /**
             * Creates a dependency provider for protobuf (org.jetbrains.kotlinx:kotlinx-serialization-protobuf)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getProtobuf() { return create("kotlinx.serialization.protobuf"); }

    }

    public static class LogbackLibraryAccessors extends SubDependencyFactory {

        public LogbackLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for classic (ch.qos.logback:logback-classic)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getClassic() { return create("logback.classic"); }

    }

    public static class Nd4jLibraryAccessors extends SubDependencyFactory {
        private final Nd4jNativeLibraryAccessors laccForNd4jNativeLibraryAccessors = new Nd4jNativeLibraryAccessors(owner);

        public Nd4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at nd4j.native
         */
        public Nd4jNativeLibraryAccessors getNative() { return laccForNd4jNativeLibraryAccessors; }

    }

    public static class Nd4jNativeLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public Nd4jNativeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for native (org.nd4j:nd4j-native)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("nd4j.native"); }

            /**
             * Creates a dependency provider for platform (org.nd4j:nd4j-native-platform)
             * This dependency was declared in settings file 'settings.gradle.kts'
             */
            public Provider<MinimalExternalModuleDependency> getPlatform() { return create("nd4j.native.platform"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
