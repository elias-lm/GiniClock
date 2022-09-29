import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.plugin.devel.PluginDeclaration
import java.io.File

class SettingsConvention : Plugin<Settings> {
    override fun apply(target: Settings) = with(target) {
        includeProjects()
        includeBuilds()
    }
}


private fun Settings.includeProjects(projectsFolderName: String = "projects") {

    recursiveProjectFinder(
        File("${rootDir}/$projectsFolderName"),
        projectsFolderName,
        "build.gradle.kts",
        ":"
    ).forEach { include(it) }

}

private fun Settings.includeBuilds(buildsFolderName: String = "gradle") {

    recursiveProjectFinder(
        File("${rootDir}/$buildsFolderName"),
        buildsFolderName,
        "settings.gradle.kts",
        "/"
    ).forEach { includeBuild(it) }

}

fun recursiveProjectFinder(
    file: File,
    projectName: String,
    gradleFileName: String,
    separator: String,
): List<String> {
    val projects = mutableListOf<String>()
    return (file.listFiles() ?: arrayOf())
        .filter { it.name != "buildSrc" }
        .filter { it.listFiles()?.contains(File(it, ".ignoreModule")) == false }
        .flatMap { childFile ->
            val name = "$projectName$separator${childFile.name}"
            if (File(childFile, gradleFileName).exists()) {
                projects.add(name)
                projects.addAll(
                    recursiveProjectFinder(
                        childFile,
                        name,
                        gradleFileName,
                        separator,
                    )
                )
                projects
            } else {
                recursiveProjectFinder(childFile, name, gradleFileName, separator)
            }
        }
}