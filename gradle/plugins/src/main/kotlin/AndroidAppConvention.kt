import Tools.implementation
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.register
import org.gradle.plugin.devel.PluginDeclaration

class AndroidAppConvention : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Dependencies.Plugins.android_application)
        pluginManager.apply(Dependencies.Plugins.kotlin_android)
        pluginManager.apply(Dependencies.Plugins.kotlin_serialization)
        pluginManager.apply(Dependencies.Plugins.google_services)
        pluginManager.apply(FirebaseConvention::class)
        pluginManager.apply(ComposeConvention::class)

        extensions.configure<BaseAppModuleExtension> {
            androidConfig()
            defaultConfig {
                targetSdk = 32
//                applicationId = "org.gradle.kotlin.dsl.samples.androidstudio"
                versionCode = 1 //TODO
                versionName = "1.0" //TODO
            }

            buildTypes {
                release {
                    isMinifyEnabled = false

                }
                debug {
                    isMinifyEnabled = false
                }
            }
        }

        dependencies {
            implementation(Dependencies.Libraries.AndroidX.activity_compose)
            implementation(Dependencies.Libraries.AndroidX.navigation_compose)
            implementation(Dependencies.Libraries.AndroidX.navigation_ui_kts)
            implementation(Dependencies.Libraries.Koin.core)
            implementation(Dependencies.Libraries.Koin.android)
            implementation(Dependencies.Libraries.Koin.android_compose)
        }
    }

}