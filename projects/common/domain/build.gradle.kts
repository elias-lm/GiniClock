plugins {
    id("android.library.convention")
    id("multiplatform.convention")
    id("firebase.convention")
}

android {
    namespace = "mad.dev.common.domain"
}

dependencies {
    implementation(Dependencies.Libraries.Koin.core)
}