plugins {
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.kotlin-test")
    id("common.gradle.scripts.spotless-kotlin")
}

dependencies {
    implementation(project(":java"))
}
