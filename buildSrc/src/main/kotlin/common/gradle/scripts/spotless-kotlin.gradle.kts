package common.gradle.scripts

plugins {
    @Suppress("SpellCheckingInspection")
    id("com.diffplug.spotless")
}

@Suppress("SpellCheckingInspection", "PropertyName")
val `ktlint-version`: String by extra

spotless {
    // see https://github.com/pinterest/ktlint#custom-ktlint-specific-editorconfig-properties
    val importLayout = "org.tarodbofh.*,*,java.*,javax.*,kotlin.*,kotlinx.*,^*,^org.tarodbofh.*"

    kotlin {
        ktlint(`ktlint-version`).userData(mapOf(
            "insert_final_newline" to "true",
            //"disabled_rules" to "import_ordering",
            "kotlin_imports_layout" to importLayout,
            "ij_kotlin_imports_layout" to importLayout
        ))
    }

    kotlinGradle {
        target(fileTree(projectDir).apply {
            include("*.gradle.kts")
        } + fileTree("src").apply {
            include("**/*.gradle.kts")
        })
        ktlint(`ktlint-version`).userData(mapOf(
            "insert_final_newline" to "true",
            //"disabled_rules" to "import_ordering",
            "kotlin_imports_layout" to importLayout,
            "ij_kotlin_imports_layout" to importLayout
        ))
    }
}
