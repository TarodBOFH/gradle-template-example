package common.gradle.scripts

plugins {
    id("common.gradle.scripts.junit-test")
}

val hamcrest: String by extra

dependencies {
    testImplementation("org.hamcrest:hamcrest:$hamcrest")
}

tasks.test {
    doFirst {
        logger.lifecycle("Hamcrest version $hamcrest")
    }
}
