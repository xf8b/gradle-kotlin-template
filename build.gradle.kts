/*
 * gradle-kotlin-template - a template for creating Gradle projects that use Kotlin
 * Written in 2022 by xf8b.
 *
 * To the extent possible under law, the author(s) have dedicated all copyright
 * and related and neighboring rights to this software to the public domain worldwide.
 *
 * This software is distributed without any warranty.
 *
 * You should have received a copy of the CC0 Public Domain Dedication along with this software.
 * If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java // language
    kotlin("jvm") version "1.6.10" // language
}

group = "com.example"
base.archivesName.set("example")
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2")) // testing
    testImplementation("org.junit.jupiter:junit-jupiter") // testing
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // require java 17
        vendor.set(JvmVendorSpec.ADOPTIUM) // get jdk from adoptium if none are found
    }
}

tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "17" // target jvm 17
            languageVersion = "1.6" // be compatible with kotlin 1.6
        }
    }

    test {
        useJUnitPlatform() // use junit for testing
    }
}