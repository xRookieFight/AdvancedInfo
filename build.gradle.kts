plugins {
    kotlin("jvm") version "2.1.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.xrookiefight"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.opencollab.dev/maven-releases")
    maven("https://repo.opencollab.dev/maven-snapshots")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("com.github.PowerNukkitX:PowerNukkitX:master-SNAPSHOT")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        archiveVersion.set("")

        mergeServiceFiles()
    }

    build {
        dependsOn(shadowJar)
    }
}