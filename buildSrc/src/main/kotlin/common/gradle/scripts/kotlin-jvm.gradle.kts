package common.gradle.scripts

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("common.gradle.scripts.java")
}

repositories {
    mavenCentral()
    jcenter()
}

val javaTarget: String by extra
val kotlinTarget: String by extra
val kotlinVersion: String by extra

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        languageVersion = kotlinTarget
        apiVersion = kotlinTarget
        jvmTarget = JavaVersion.toVersion(javaTarget).toString()
        javaParameters = true
    }
    doFirst {
        printKotlinOptions()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
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
    }
}
