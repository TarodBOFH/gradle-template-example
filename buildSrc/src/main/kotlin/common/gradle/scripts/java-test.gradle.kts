package common.gradle.scripts

plugins {
    id("common.gradle.scripts.java")
    id("common.gradle.scripts.junit")
}

@Suppress("PropertyName")
val `assertj-version`: String by extra

dependencies {
    testImplementation("org.assertj:assertj-core:${`assertj-version`}")
}

tasks.test {
    doFirst {
        logger.lifecycle("Assertj version $`assertj-version`")
    }
}
