import site.algosipeosseong.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
            }
//                implementation 'com.google.dagger:hilt-android:2.51.1'
//                kapt 'com.google.dagger:hilt-compiler:2.51.1'
//
//                // For instrumentation tests
//                androidTestImplementation  'com.google.dagger:hilt-android-testing:2.51.1'
//                kaptAndroidTest 'com.google.dagger:hilt-compiler:2.51.1'
//
//                // For local unit tests
//                testImplementation 'com.google.dagger:hilt-android-testing:2.51.1'
//                kaptTest 'com.google.dagger:hilt-compiler:2.51.1'

            dependencies {
                "implementation"(libs.findLibrary("hilt.android").get())
                "ksp"(libs.findLibrary("hilt.ext.compiler").get())
                "ksp"(libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}