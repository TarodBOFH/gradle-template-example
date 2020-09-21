package common.gradle.scripts

plugins {
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.junit-test")
}

val mockk: String by extra
val assertk: String by extra

dependencies {
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-annotations-common"))
    testImplementation(kotlin("test-junit5"))
    testImplementation("io.mockk:mockk:$mockk")
    @Suppress("SpellCheckingInspection")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:$assertk")

}

tasks.test {
    doFirst {
        logger.lifecycle("Assertk version $assertk")
        logger.lifecycle("Mockk version $mockk")
    }
}
