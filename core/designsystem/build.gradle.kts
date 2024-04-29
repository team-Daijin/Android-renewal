plugins {
    alias(libs.plugins.knowledgender.android.library)
    alias(libs.plugins.knowledgender.compose.library)
}

android {
    namespace = "site.algosipeosseong.designsystem"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    debugImplementation(libs.androidx.compose.ui.tooling.preview)
    api(libs.accompanist.pager)
    api(libs.coil.kt)
    api(libs.viewPager.indicator)
    api(libs.viewPager)
    api(libs.coil.kt.compose)
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}