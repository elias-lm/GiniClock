import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import kotlin.reflect.KClass

object Tools {

    fun DependencyHandlerScope.implementation(name: Any) {
        add("implementation", name)
    }

    fun <T : Any> Project.configureIfExists(type: KClass<T>, configure: T.() -> Unit) {
        if (extensions.findByType(type) != null) {
            extensions.configure(type, configure)
        }
    }

}
