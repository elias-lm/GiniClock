import Tools.implementation
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class FirebaseConvention : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        dependencies {
            implementation(platform(Dependencies.BOMS.firebase))
            implementation(Dependencies.Libraries.Firebase.analytics)
            implementation(Dependencies.Libraries.Firebase.database)
            implementation(Dependencies.Libraries.Firebase.database_ktx)
        }
    }

}