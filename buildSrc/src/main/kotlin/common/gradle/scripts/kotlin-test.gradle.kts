package common.gradle.scripts

plugins {
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.junit-test")
}

val assertj:String by extra

dependencies {
    testImplementation("org.assertj:assertj-core:$assertj")
}

tasks.test {
    doFirst {
        logger.lifecycle("Assertj version $assertj")
    }
}
