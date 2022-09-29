import Tools.configureIfExists
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class DesktopConvention : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(ComposeConvention::class)
        pluginManager.apply(MultiplatformConvention::class)

        //Multiplatform
        configureIfExists(KotlinMultiplatformExtension::class) {
            jvm {
                compilations.all {
                    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
                }
                withJava()
            }
            sourceSets.apply {
                named("jvmMain") {
                    dependencies {
                        implementation(compose.desktop.currentOs)
                    }
                }
            }
        }

        //Compose
        configureIfExists(DesktopExtension::class) {
            application {
                mainClass = "MainKt"
                nativeDistributions {
                    targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                }
            }
        }

    }
}