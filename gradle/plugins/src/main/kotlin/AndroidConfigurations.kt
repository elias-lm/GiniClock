import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun CommonExtension<*, *, *, *>.androidConfig() {

    compileSdk = 32
    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

//    kotlinOptions {
//        this.jvmTarget = JavaVersion.VERSION_1_8.toString()
//    }
}

fun CommonExtension<*, *, *, *>.androidComposeConfig() {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1" //dev.mad.eli.Dependencies.Android.Compose.VERSION
    }
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}