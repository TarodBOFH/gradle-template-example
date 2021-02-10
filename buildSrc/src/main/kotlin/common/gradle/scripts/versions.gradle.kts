package common.gradle.scripts

apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts") // parent properties
if (File("${rootProject.projectDir}/versions.gradle.kts").exists()) {
    apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
}
if (File("${project.projectDir}/versions.gradle.kts").exists()) {
    apply(from = "${project.projectDir}/versions.gradle.kts") // can override "rootProject" properties
}
