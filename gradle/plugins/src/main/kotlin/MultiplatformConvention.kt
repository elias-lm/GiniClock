import Tools.configureIfExists
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class MultiplatformConvention : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Dependencies.Plugins.multiplatform)
        pluginManager.apply(Dependencies.Plugins.kotlin_serialization)

        configureIfExists(KotlinMultiplatformExtension::class) {
            if (extensions.findByType(LibraryExtension::class) != null) {
                android()
            }
            if (extensions.findByType(BaseAppModuleExtension::class) != null) {
                android()
            }
            jvm("desktop")

            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach {
                it.binaries.framework {
                    baseName = "common"
                }
            }

            sourceSets {
                val commonMain by getting {
                    dependencies {
                        api(Dependencies.Libraries.kotlin_date_time)
                        api(Dependencies.Libraries.kotlin_serialization_json)
                    }
                }
                val commonTest by getting {
                    dependencies {
                        implementation(kotlin("test"))
                    }
                }
                val androidMain by getting {
                    dependsOn(commonMain)
                }
                val androidTest by getting {
                    dependsOn(commonTest)
                }

                val iosX64Main by getting
                val iosArm64Main by getting
                val iosSimulatorArm64Main by getting
                val iosMain by creating {
                    dependsOn(commonMain)
                    iosX64Main.dependsOn(this)
                    iosArm64Main.dependsOn(this)
                    iosSimulatorArm64Main.dependsOn(this)
                }
                val iosX64Test by getting
                val iosArm64Test by getting
                val iosSimulatorArm64Test by getting
                val iosTest by creating {
                    dependsOn(commonTest)
                    iosX64Test.dependsOn(this)
                    iosArm64Test.dependsOn(this)
                    iosSimulatorArm64Test.dependsOn(this)
                }
            }
            //TODO add JS, IOS
        }

    }
}


//val KotlinMultiplatformExtension.`sourceSets`: NamedDomainObjectContainer<KotlinSourceSet> get() =
//    (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("sourceSets") as NamedDomainObjectContainer<KotlinSourceSet>
//
//fun KotlinMultiplatformExtension.`sourceSets`(configure: Action<NamedDomainObjectContainer<KotlinSourceSet>>): Unit =
//    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("sourceSets", configure)

