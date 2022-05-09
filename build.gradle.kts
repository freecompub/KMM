buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}