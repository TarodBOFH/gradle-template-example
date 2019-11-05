package common.gradle.scripts

plugins {
    java
}

repositories {
    mavenCentral()
}

val javaTarget: String by extra

java {
    sourceCompatibility = JavaVersion.toVersion(javaTarget)
    targetCompatibility = JavaVersion.toVersion(javaTarget)
}

tasks.compileJava {
    options.compilerArgs.add("-parameters")
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
        logger.lifecycle("\tJDK Version ${toolChain.version}")
        logger.lifecycle("\tCompiler Args ${options.compilerArgs}")
    }
}
