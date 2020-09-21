buildscript {
    apply (from = "versions.gradle.kts")
}

val kotlinVersion: String by extra
val spotlessPlugin: String by extra

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10") // be careful with https://youtrack.jetbrains.com/issue/KT-41142
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion") // be careful with https://youtrack.jetbrains.com/issue/KT-41142
    @Suppress("SpellCheckingInspection")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:$spotlessPlugin")
}
