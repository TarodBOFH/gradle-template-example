package common.gradle.scripts

plugins {
    java
}

repositories {
    mavenCentral()
}

@Suppress("PropertyName")
val `java-target`: String by extra

java {
    sourceCompatibility = JavaVersion.toVersion(`java-target`)
    targetCompatibility = JavaVersion.toVersion(`java-target`)
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("-parameters")
    @Suppress("SpellCheckingInspection")
    options.compilerArgs.add("-Xlint:unchecked")
    options.isDeprecation = true

    doFirst {
        printJavaOptions()
    }
}

tasks.create("printJavaOptions") {
    group = "other"
    doFirst {
        printJavaOptions()
    }
}

fun printJavaOptions() {
    tasks.compileJava.orNull?.apply {
        logger.lifecycle("Java options:")
        logger.lifecycle("\tLanguage Version $sourceCompatibility")
        logger.lifecycle("\tJVM Target $targetCompatibility")
        logger.lifecycle("\tJDK Version ${JavaVersion.current()}")
        logger.lifecycle("\tCompiler Args ${options.compilerArgs}")
    }
}
