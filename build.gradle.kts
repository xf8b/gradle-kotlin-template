import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.7.0"
}

group = "com.example"
base.archivesName.set("project")
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2")) // JUnit bill of materials
    testImplementation("org.junit.jupiter:junit-jupiter") // JUnit Jupiter
}

kotlin {
    jvmToolchain {
        this as JavaToolchainSpec

        languageVersion.set(JavaLanguageVersion.of(17)) // require Java 17
        vendor.set(JvmVendorSpec.ADOPTIUM) // get a JDK from Adoptium if none are found
    }
}

tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "17" // target JVM 17
            languageVersion = "1.6" // be compatible with Kotlin 1.6
        }
    }

    test {
        useJUnitPlatform() // use JUnit for testing
    }
}