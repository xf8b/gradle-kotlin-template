plugins {
    java
    kotlin("jvm") version "1.7.10"
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
        languageVersion.set(JavaLanguageVersion.of(18)) // require Java 18
        vendor.set(JvmVendorSpec.ADOPTIUM) // get a JDK from Adoptium if none are found
    }
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            // target the current java version used (which should be Java 18)
            jvmTarget = JavaVersion.current().toString()
        }
    }

    test {
        useJUnitPlatform() // use JUnit for testing
    }
}