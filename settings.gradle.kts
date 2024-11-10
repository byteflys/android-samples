pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

plugins {
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("com.android.application") version "8.7.0" apply false
    id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
    id("com.vanniktech.maven.publish") version "0.29.0" apply false
}

include(":app")