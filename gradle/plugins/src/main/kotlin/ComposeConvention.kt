import Tools.configureIfExists
import Tools.implementation
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeConvention : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.compose")

        configureIfExists(BaseAppModuleExtension::class) {
            androidComposeConfig()

            dependencies {
                implementation(Dependencies.Libraries.Compose.compose_runtime)
                implementation(Dependencies.Libraries.Compose.compose_ui)
                implementation(Dependencies.Libraries.Compose.compose_foundation)
                implementation(Dependencies.Libraries.Compose.compose_foundation_layout)
                implementation(Dependencies.Libraries.Compose.compose_material)
                implementation(Dependencies.Libraries.Compose.compose_constraint_layout)
                implementation(Dependencies.Libraries.Compose.compose_ui_tooling_preview)
                implementation(Dependencies.Libraries.Compose.compose_ui_tooling)
            }
        }

        configureIfExists(LibraryExtension::class) {
            androidComposeConfig()

            dependencies {
                implementation(Dependencies.Libraries.Compose.compose_runtime)
            }
        }

        configureIfExists(KotlinMultiplatformExtension::class) {
            //TODO
        }

    }
}
