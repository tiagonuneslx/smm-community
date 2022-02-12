plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "app.smmcommunity.app.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0.0-alpha.1+$versionCode"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.1")
    implementation("androidx.compose.material:material:1.1.0")
    implementation("androidx.compose.animation:animation:1.1.0")
    implementation("androidx.compose.ui:ui-tooling:1.1.0")
    implementation("com.google.accompanist:accompanist-insets:0.23.0")
    implementation("com.google.accompanist:accompanist-insets-ui:0.23.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.23.0")
    // TODO: Will be moved to Jetpack Navigation library https://issuetracker.google.com/issues/197140101
    implementation("com.google.accompanist:accompanist-navigation-animation:0.23.0")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0")
}