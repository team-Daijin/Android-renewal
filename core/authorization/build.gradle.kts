import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.knowledgender.android.library)
    alias(libs.plugins.google.gms)
}

val properties = Properties()
properties.load(FileInputStream("local.properties"))
android {
    namespace = "site.algosipeosseong.authorization"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "OAUTH", properties.getProperty("OAUTH"))
    }
    buildFeatures {
        buildConfig = true
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
    implementation(libs.google.oauth)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}