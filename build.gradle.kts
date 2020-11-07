/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.6.1/userguide/tutorial_java_projects.html
 */

plugins {
    java
    application
    idea
    id("com.palantir.graal") version "0.7.2"
    id("io.freefair.lombok") version "5.2.1"
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:29.0-jre")
    implementation("info.picocli:picocli:4.1.0")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    annotationProcessor("info.picocli:picocli-codegen:4.1.0")
    annotationProcessor("org.projectlombok:lombok:1.18.16")

    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

application {
    mainClassName = "com.github.trevorwhitney.minesweeper.App"
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
    exclude("module-info.class")
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

val compileJava by tasks.getting(JavaCompile::class) {
    doFirst {
        options.compilerArgs = listOf("--module-path", classpath.asPath)
    }

    sourceCompatibility = "11"
    targetCompatibility = "11"
}

apply {
    from("$projectDir/graal.gradle")
}

configure<org.gradle.plugins.ide.idea.model.IdeaModel> {
    module {
        outputDir = File("$buildDir/classes/main")
        testOutputDir = File("$buildDir/classes/test")
    }
}