package common.gradle.scripts

plugins {
    id("common.gradle.scripts.kotlin-jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

repositories {
    mavenCentral()
}

@Suppress("PropertyName")
val `springboot-version`: String by extra
@Suppress("SpellCheckingInspection", "PropertyName")
val `springcloud-version`: String by extra
@Suppress("PropertyName")
val `httpclient-version`: String by extra
@Suppress("PropertyName")
val `logbook-version`: String by extra

dependencies {
    // Spring Framework
    implementation(platform("org.springframework.boot:spring-boot-dependencies:${`springboot-version`}"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-context-support")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-actuator")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Spring Cloud Artifacts
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${`springcloud-version`}"))
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth") {
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-jms")
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-kafka-clients")
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-kafka-streams")
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-messaging")
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-rpc")
        exclude(group = "io.zipkin.brave", module = "brave-instrumentation-spring-rabbit")
        exclude(group = "io.zipkin.reporter2", module = "zipkin-reporter-metrics-micrometer")
        exclude(group = "org.springframework.security", module = "spring-security-crypto")
        exclude(group = "org.springframework.security", module = "spring-security-rsa")
    }

    // Other Libraries
    @Suppress("SpellCheckingInspection")
    implementation("org.apache.httpcomponents:httpclient:${`httpclient-version`}")
    implementation("org.zalando:logbook-spring-boot-starter:${`logbook-version`}")

    // Test Packages
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }

    // Spring dev tools for local development
    implementation("org.springframework.boot:spring-boot-devtools")
}

tasks.create("printSpringOptions") {
    group = "other"
    doFirst {
        printSpringOptions()
    }
}

fun printSpringOptions() {
    tasks.compileKotlin.orNull?.apply {
        logger.lifecycle("Spring options:")
        logger.lifecycle("\tSpringboot Version $`springboot-version`")
        logger.lifecycle("\tSpringCloud Version $`springcloud-version``")
        logger.lifecycle("\thttpclient Version $`httpclient-version``")
        logger.lifecycle("\tlogbook Version $`logbook-version``")
    }
}

tasks.processResources {
    expand(project.properties)
}
