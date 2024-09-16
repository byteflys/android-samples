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
    implementation("io.github.hellogoogle2000:kotlin-commons:1.0.6")
    implementation("io.github.hellogoogle2000:android-commons:1.0.17")
    implementation("io.github.hellogoogle2000:android-commons-ui:1.0.9")
}