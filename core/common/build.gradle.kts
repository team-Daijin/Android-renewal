plugins {
    alias(libs.plugins.knowledgender.android.library)
    alias(libs.plugins.knowledgender.compose.library)
}

android {
    namespace = "site.algosipeosseong.common"
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

//add("implementation", libs.findLibrary("androidx.compose.material3").get())
//add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
//add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())
dependencies {
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}