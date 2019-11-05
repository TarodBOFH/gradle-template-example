plugins {
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.kotlin-test")
    id("common.gradle.scripts.spotless-kotlin")
}

dependencies {
    implementation(project(":java"))
    testImplementation("io.mockk:mockk:1.9.3")
}
