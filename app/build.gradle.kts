plugins {
    id("org.jetbrains.kotlin.android")
    id("com.android.application")
}

android {

    compileSdk = 34
    defaultConfig {
        namespace = "x.android.samples"
        minSdk = 30
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    // Commons Serial
    api("io.github.hellogoogle2000:android-commons:1.0.28")
    debugApi("androidx.compose.ui:ui-tooling:1.7.5")
    debugApi("androidx.compose.ui:ui-tooling-preview:1.7.5")
    debugApi("androidx.compose.ui:ui-tooling-preview-android:1.7.5")
}