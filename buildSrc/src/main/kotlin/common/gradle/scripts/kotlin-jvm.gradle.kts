package common.gradle.scripts

plugins {
    kotlin("jvm")
    id("common.gradle.scripts.java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

val javaTarget: String by extra
val kotlinTarget: String by extra

tasks.compileKotlin {
    kotlinOptions {
        languageVersion = kotlinTarget
        apiVersion = kotlinTarget
        jvmTarget = javaTarget
        javaParameters = true
    }
    doFirst {
        printKotlinOptions()
    }
}

java {
    sourceCompatibility = JavaVersion.toVersion(javaTarget)
    targetCompatibility = JavaVersion.toVersion(javaTarget)
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
