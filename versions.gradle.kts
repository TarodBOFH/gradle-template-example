// Core
extra["java-target"] = "11"

if (java.io.File("${project.projectDir}/versions.gradle.kts").exists() && project != rootProject) {
    apply(from = "${project.projectDir}/versions.gradle.kts") // can override "rootProject" properties
}
