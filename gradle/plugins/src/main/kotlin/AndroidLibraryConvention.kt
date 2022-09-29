import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConvention : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Dependencies.Plugins.android_library)
        extensions.configure<LibraryExtension> {
            androidConfig()
            defaultConfig.targetSdk = 33
        }
    }

}