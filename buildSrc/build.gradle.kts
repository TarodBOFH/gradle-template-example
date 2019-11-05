buildscript {
    apply (from = "versions.gradle.kts")
}

val kotlinVersion: String by extra

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jmailen.gradle:kotlinter-gradle:2.1.2")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:3.25.0")
}
