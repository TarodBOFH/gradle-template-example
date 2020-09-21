package common.gradle.scripts

import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
}

val javaTarget: String by extra

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
    project {
        jdkName = javaTarget
        languageLevel = IdeaLanguageLevel(JavaVersion.toVersion(javaTarget))
    }
}
