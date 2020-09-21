plugins {
    id("common.gradle.scripts.idea")
    id("common.gradle.scripts.versions")
}

allprojects {
    buildscript {
        apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts") // parent properties
        apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.6.1"
}
