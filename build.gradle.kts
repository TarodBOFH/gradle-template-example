plugins {
    id("common.gradle.scripts.idea")
}

allprojects {
    buildscript {
        apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts")
        apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "5.6.2"
}
