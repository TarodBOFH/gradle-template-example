package common.gradle.scripts

import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
}

@Suppress("PropertyName")
val `java-target`: String by extra

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
    project {
        jdkName = `java-target`
        languageLevel = IdeaLanguageLevel(JavaVersion.toVersion(`java-target`))
    }
}
