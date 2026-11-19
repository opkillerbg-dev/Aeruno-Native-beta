import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.aeruno.nativeprototype"
    compileSdk = 36

    defaultConfig {
        // Temporary prototype id. NOT a release identity (see AGENTS.md section 3).
        applicationId = "com.aeruno.nativeprototype"
        minSdk = 31
        targetSdk = 36
        // CI passes the run number so every build has a higher versionCode.
        versionCode = (findProperty("buildNumber") as String?)?.toIntOrNull() ?: 1
        versionName = "0.1.0-n03"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
    // No release signing and no release config on purpose: debug builds only.
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.haze) // N03: backdrop blur, used only inside ui/glass/GlassSurface.kt
}
