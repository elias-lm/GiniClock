plugins {
    id("android.library.convention")
    id("multiplatform.convention")
    id("compose.convention")

}

android {
    namespace = "mad.dev.common"
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.baseComposeMultiplatform.projects.common.domain)
                implementation(projects.baseComposeMultiplatform.projects.common.data)
                implementation(projects.baseComposeMultiplatform.projects.common.presentation)
            }
        }
    }
}

dependencies {
}