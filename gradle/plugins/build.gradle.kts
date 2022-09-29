plugins {
    id("org.gradle.kotlin.kotlin-dsl") version "3.1.0"
    `java-gradle-plugin`
}

group = "gradle.build.logic"

dependencies {
    implementation("gradle.build.logic:dependencies")

    implementation(Dependencies.Libraries.android_tools_gradle)
    implementation(Dependencies.Libraries.kotlin_gradle)
    implementation(Dependencies.Libraries.jetbrains_compose_gradle)
    implementation(Dependencies.Libraries.google_services)
    implementation(Dependencies.Libraries.kotlin_serialization)
//    implementation(Dependencies.Libraries.ksp_gradle)
}

gradlePlugin {
    plugins {
        register("gradle.settings.convention") {
            id = "gradle.settings.convention"
            implementationClass = "SettingsConvention"
        }
        register("android.app.convention") {
            id = "android.app.convention"
            implementationClass = "AndroidAppConvention"
        }
        register("android.library.convention") {
            id = "android.library.convention"
            implementationClass = "AndroidLibraryConvention"
        }
        register("multiplatform.convention") {
            id = "multiplatform.convention"
            implementationClass = "MultiplatformConvention"
        }
        register("desktop.convention") {
            id = "desktop.convention"
            implementationClass = "DesktopConvention"
        }
        register("compose.convention") {
            id = "compose.convention"
            implementationClass = "ComposeConvention"
        }
        register("firebase.convention") {
            id = "firebase.convention"
            implementationClass = "FirebaseConvention"
        }
    }
}