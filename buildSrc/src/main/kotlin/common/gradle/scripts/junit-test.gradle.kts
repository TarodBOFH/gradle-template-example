package common.gradle.scripts

import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("common.gradle.scripts.java")
}

val junit: String by extra

dependencies {
    testImplementation(platform("org.junit:junit-bom:$junit"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}

tasks.test {
    @Suppress("UnstableApiUsage")
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
        lifecycle {
            exceptionFormat = TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
        }
        info.events = lifecycle.events
        info.exceptionFormat = lifecycle.exceptionFormat
    }

    doFirst {
        logger.lifecycle("junit version $junit")
    }
}

// JUnit's cleanTest task doesn't have an accessor on tasks nor provides a description
// See Gradle best practices at "https://docs.gradle.org/current/userguide/authoring_maintainable_build_scripts.html#sec:declaring_tasks"
tasks.named("cleanTest")  {
    group = "verification"
    description = "Cleans test result cache, so new test invocations won't be marked as \"UP-TO-DATE\""
}
