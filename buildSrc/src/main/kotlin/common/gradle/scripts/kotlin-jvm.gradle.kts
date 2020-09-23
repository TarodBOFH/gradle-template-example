package common.gradle.scripts

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

repositories {
    mavenCentral()
    jcenter()
}

@Suppress("PropertyName")
val `java-target`: String by extra
@Suppress("PropertyName")
val `kotlin-target`: String by extra
@Suppress("PropertyName")
val `kotlin-version`: String by extra
@Suppress("PropertyName")
val `kotlin-logging-version`: String by extra

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        languageVersion = `kotlin-target`
        apiVersion = `kotlin-target`
        jvmTarget = JavaVersion.toVersion(`java-target`).toString()
        javaParameters = true
    }
    doFirst {
        printKotlinOptions()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    @Suppress("SpellCheckingInspection")
    implementation("io.github.microutils:kotlin-logging:${`kotlin-logging-version`}")
}

tasks.create("printKotlinOptions") {
    group = "other"
    doFirst {
        printKotlinOptions()
    }
}

fun printKotlinOptions() {
    tasks.compileKotlin.orNull?.apply {
        logger.lifecycle("Kotlin options:")
        logger.lifecycle("\tLanguage Version ${kotlinOptions.languageVersion}")
        logger.lifecycle("\tApi Version ${kotlinOptions.apiVersion}")
        logger.lifecycle("\tJava Parameters ${kotlinOptions.javaParameters}")
        logger.lifecycle("\tJVM Target ${kotlinOptions.jvmTarget}")
        logger.lifecycle("\tJDK Home ${kotlinOptions.jdkHome}")
        logger.lifecycle("\tFree Compiler Args ${kotlinOptions.freeCompilerArgs}")
        logger.lifecycle("\tEmbedded Kotlin $embeddedKotlinVersion")
        logger.lifecycle("Kotlin Library Versions:")
        logger.lifecycle("\tKotlin Logging $`kotlin-logging-version`")
    }
}
