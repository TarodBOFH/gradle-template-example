# gradle-template-example
Advanced gradle template using Kotlin DSL

## Introduction
This is an advanced gradle kotlin project template using gradle's kotlin DSL

Features: 
- Multimodule setup: Modules reside in `modules` folder. Please refer to `settings.gradle.kts` for further information
- `buildSrc` plugin scripts to be imported like the old groovy `apply from` format
- Extra properties as an example, as global `versions.gradle.kts` on `buildSrc`, overridden on the rootProject and then 
  overridden per module on `buildscript {}` block
- Preconfigured `java` and `java-test` plugin scripts
- Preconfigured `kotlin-jvm` and `kotlin-test` plugin scripts, with spotless and klint (java plugin scripts doesn't have any linter)
- Preconfigured junit 5 script plugin with test summary output
- Preconfigured basic `idea` plugin
- Preconfigured springboot plugin and libraries with exclusions with a `spring` module with tracing, logging and so.
- `.gitignore` template 
- `.gitattributes` template
- sample `init.gradle.kts` properties
- Some logging information added to several tasks, like version and properties output on `compileJava`, `compileKotlin`
- More logging information added to test, like logging version of the libraries included
- Different flavour per module (i.e. java module uses `assertj` and mockito while kotlin uses assertj and mockk
- Modules dependencies: `kotlin` module depends on `java` module by `implementation` flavour
- Gradle Wrapper included in the sources
- Gradle wrapper task example on root `build.gradle.kts`

This template is offered as it is as a learning resource or as a starting point to override and customize to everyone's 
needs.
Some design choices made are an intentional exaggeration to illustrate with examples what can be done.
Please review before using this on production and tailor it to your needs.

Please bear in mind that gradle recommends applying plugins on root project buildscript but that recommendation has been 
ignored on this template. The reasoning behind this is to make every buildscript minimal. 
If your buildscripts require the same plugin, please add it to the root buildscript as per gradle recommendations. 
See https://docs.gradle.org/current/userguide/kotlin_dsl.html#sec:multi_project_builds_applying_plugins for additional information:
For example, to load `common.gradle.scripts.java` plugin on root buildscript but don't apply it:
```
plugins {
    id("common.gradle.scripts.java") false
}
```
Then it will be available (loaded) for modules. This might improve your build times if your plugins are shared across 
modules.

## How is it done?

Convention over Configuration.

The template offers a hook, `versions.gradle.kts`, sitting on `buildSrc` (that includes the default versions).
It also loads `versions.gradle.kts` sitting on root project to override the versions in `buildSrc`.
The whole idea is to allow a company package `buildSrc` in either a git subtree, 
or a custom gradle distribution (see https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:custom_gradle_distribution)
to  embed a custom `buildSrc` for the company builds.

Also, modules can override their properties either by adding a `buildscript` block to override some default versions.
Additionally, if the file `versions.gradle.kts` exists in the module root folder, it will overwrite the parent and
`buildSrc` versions. 
In the examples provided, the `java` submodule is overriding jvm target with a `buildscript` block 
and the `kotlin` module is overriding the version of kotlin logging library with a `versions.gradle.kts` file.

## Dummy Tests
Dummy tests exist to force the test task failure.

## Single Module projects
- Remove `java`, `kotlin` and `spring` modules
- Add default `src` at `projectRoot` folder with the standard convention: `$projectRoot/src/{main, test}/{java, kotlin}`
- Edit `settings.gradle.kts` and remove the `include` section
