plugins {
    kotlin("multiplatform") version ("1.5.0-M2")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets {

        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.1.1")
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        named("jvmTest") {
            dependencies {
                val jupiterVersion = "5.7.1"
                implementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
                implementation(kotlin("test-junit5"))
            }
        }
    }
}

tasks {

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            languageVersion = "1.5"
        }
    }

    withType(Test::class.java) {
        useJUnitPlatform()
    }
}
