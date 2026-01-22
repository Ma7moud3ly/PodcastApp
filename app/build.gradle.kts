import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ma7moud3ly.podcast"

    compileSdk = 36
    defaultConfig {
        applicationId = "ma7moud3ly.podcast"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        debug {
            buildConfigField("String", "API_HOME", "\"https://api-v2-b2sit6oh3a-uc.a.run.app/\"")
            buildConfigField("String", "API_SEARCH", "\"https://mock.apidog.com/m1/735111-711675-default/\"")
        }
        release {
            buildConfigField("String", "API_HOME", "\"https://api-v2-b2sit6oh3a-uc.a.run.app/\"")
            buildConfigField("String", "API_SEARCH", "\"https://mock.apidog.com/m1/735111-711675-default/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons)

    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)

    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)

    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.dagger.hilt.compiler)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlinx.serialization.converter)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.coil)
    implementation(libs.coil.network.okhttp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}