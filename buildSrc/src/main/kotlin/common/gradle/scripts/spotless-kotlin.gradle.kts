package common.gradle.scripts

plugins {
    id("com.diffplug.gradle.spotless")
    id("org.jmailen.kotlinter")
}

spotless {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        target(fileTree(projectDir).apply {
            include("*.gradle.kts")
        } + fileTree("src").apply {
            include("**/*.gradle.kts")
        })
        ktlint()
    }
}
