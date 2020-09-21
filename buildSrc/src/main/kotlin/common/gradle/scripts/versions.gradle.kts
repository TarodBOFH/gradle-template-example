package common.gradle.scripts

apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts") // parent properties
apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
