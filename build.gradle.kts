// Plugin versions live in gradle/libs.versions.toml. Nothing else belongs in this file.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
