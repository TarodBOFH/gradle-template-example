@file:Suppress("PropertyName", "SpellCheckingInspection")

buildscript {
    apply (from = "versions.gradle.kts")
}

val `kotlin-version`: String by extra
val `spotless-plugin-version`: String by extra
val `springboot-version`: String by extra

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10") // be careful with https://youtrack.jetbrains.com/issue/KT-41142
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${`kotlin-version`}") // be careful with https://youtrack.jetbrains.com/issue/KT-41142
    implementation("org.jetbrains.kotlin:kotlin-allopen:${`kotlin-version`}")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${`springboot-version`}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${`spotless-plugin-version`}")
}
