plugins {
    alias(libs.plugins.knowledgender.android.library)
    alias(libs.plugins.knowledgender.android.hilt)
}



android {
    namespace = "site.algosipeosseong.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.hilt.core)
}