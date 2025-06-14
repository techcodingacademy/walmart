plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.demoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.demoapp"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildFeatures {
            //noinspection DataBindingWithoutKapt
            dataBinding = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.converter)
    implementation(libs.okhttp.client)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.okhttp.mockwebserver)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.retrofit)
    implementation(libs.androidx.recyclerview)
    implementation(libs.kotlinx.viemodels)
    implementation(libs.kotlinx.sd)
    implementation(libs.gson)
    implementation(libs.moshi)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}