buildscript {
    extra["javaTarget"] = "1.8" //overrides rootProject
}

plugins {
    id("common.gradle.scripts.java")
    id("common.gradle.scripts.java-test")
}

dependencies {
    testImplementation("org.mockito:mockito-core:2.+")
}
