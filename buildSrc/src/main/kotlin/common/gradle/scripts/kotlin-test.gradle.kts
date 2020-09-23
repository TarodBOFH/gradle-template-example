package common.gradle.scripts

plugins {
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.junit")
}

@Suppress("PropertyName")
val `mockk-version`: String by extra
@Suppress("PropertyName")
val `assertk-version`: String by extra

dependencies {
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-annotations-common"))
    testImplementation(kotlin("test-junit5"))
    testImplementation("io.mockk:mockk:${`mockk-version`}")
    @Suppress("SpellCheckingInspection")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:${`assertk-version`}")

}

tasks.test {
    doFirst {
        logger.lifecycle("Assertk version $`assertk-version`")
        logger.lifecycle("Mockk version $`mockk-version`")
    }
}
