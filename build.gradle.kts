allprojects {
    buildscript {
        apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts") // parent properties
        apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
    }
}

plugins {
    id("common.gradle.scripts.versions")
    id("common.gradle.scripts.idea")
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.8.2"
}
