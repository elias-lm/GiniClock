plugins {
    id("android.app.convention")
}


android {
    namespace = "gini.apps.giniclock"
}

dependencies {
    implementation(projects.baseComposeMultiplatform.projects.common)
}