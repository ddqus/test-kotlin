import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "io.github.ddqus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:+")
    testImplementation("org.junit.jupiter:junit-jupiter-params:+")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:+")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:+")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

application {
    mainClass.set("MainKt")
}