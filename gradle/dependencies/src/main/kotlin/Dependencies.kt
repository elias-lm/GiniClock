object Dependencies {
    object Versions {
        const val json_to_kotin = "3.7.4"
        const val kotlin_poet = "1.12.0"
        const val kotlin = "1.7.10"
        const val kotlinx_coroutines = "1.6.4"
        const val kotlin_date_time = "0.4.0"
        const val jetbrains_compose_gradle_plugin = "1.2.0-alpha01-dev774"
        const val ksp = "1.7.10-1.0.6"
        const val gradle_plugin = "7.3.0"
        const val androidx = "1.5.1"
        const val work_manager = "2.7.1"
        const val compose = "1.2.1"
        const val decompose = "0.8.0"
        const val koin = "3.2.0"
    }

    object BOMS {
        const val firebase = "com.google.firebase:firebase-bom:30.4.1"
    }

    object Libraries {
        const val kotlin_gradle =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinx_coroutines_core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines}"
        const val kotlinx_coroutines_jvm =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.kotlinx_coroutines}"
        const val kotlinx_coroutines_android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines}"

        const val jetbrains_compose_gradle =
            "org.jetbrains.compose:compose-gradle-plugin:${Versions.jetbrains_compose_gradle_plugin}"

        const val ksp_gradle =
            "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.ksp}"
        const val ksp_processor =
            "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}"

        const val json_to_kotlin = "com.sealwu.jsontokotlin:library:${Versions.json_to_kotin}"

        const val kotlin_poet = "com.squareup:kotlinpoet:${Versions.kotlin_poet}"

        const val android_tools_gradle =
            "com.android.tools.build:gradle:${Versions.gradle_plugin}"

        const val kotlin_date_time =
            "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlin_date_time}"

        const val kotlin_serialization =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

        const val kotlin_serialization_json =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0"

//        const val androidx =
//            "androidx.appcompat:appcompat:${Versions.androidx}"

        const val google_services = "com.google.gms:google-services:4.3.14"

        object Firebase {
            const val analytics = ("com.google.firebase:firebase-analytics-ktx")
            const val database = ("com.google.firebase:firebase-database")
            const val database_ktx = ("com.google.firebase:firebase-database-ktx")
        }

        object AndroidX {
            const val core_ktx = ("androidx.core:core-ktx:1.9.0")
            const val lifecycle_runtime = ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
            const val activity_compose =
                "androidx.activity:activity-compose:${Versions.androidx}"
            const val work_runtime_ktx = ("androidx.work:work-runtime-ktx:${Versions.work_manager}")
            const val navigation_ui_kts = ("androidx.navigation:navigation-ui-ktx:2.5.2")
            const val navigation_compose = ("androidx.navigation:navigation-compose:2.5.2")
        }

        object Compose {
            const val compose_ui =
                "androidx.compose.ui:ui:${Versions.compose}"
            const val compose_ui_tooling =
                "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val compose_ui_tooling_preview =
                "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
            const val compose_foundation =
                "androidx.compose.foundation:foundation:${Versions.compose}"
            const val compose_foundation_layout =
                "androidx.compose.foundation:foundation-layout:${Versions.compose}"
            const val compose_material =
                "androidx.compose.material:material:${Versions.compose}"
            const val compose_material_icons_core =
                "androidx.compose.material:material-icons-core:${Versions.compose}"
            const val compose_material_icons_extended =
                "androidx.compose.material:material-icons-extended:${Versions.compose}"
            const val compose_runtime =
                "androidx.compose.runtime:runtime:${Versions.compose}"

            const val compose_constraint_layout =
                "androidx.constraintlayout:constraintlayout-compose:1.0.1"
        }

        object Koin {
            const val core = "io.insert-koin:koin-core:${Versions.koin}"
            const val test = "io.insert-koin:koin-test:${Versions.koin}"
            const val android = "io.insert-koin:koin-android:${Versions.koin}"
            const val android_compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
            const val android_workmanager =
                "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
        }

    }

    object Plugins {
        const val android_application =
            "com.android.application"
        const val android_library =
            "com.android.library"
        const val kotlin_android =
            "org.jetbrains.kotlin.android"
        const val kotlin_jvm =
            "org.jetbrains.kotlin.jvm"
        const val kotlin_ksp =
            "com.google.devtools.ksp"
        const val jetbrains_compose =
            "org.jetbrains.compose"
        const val multiplatform =
            "org.jetbrains.kotlin.multiplatform"
        const val kotlin_serialization =
            "org.jetbrains.kotlin.plugin.serialization"
        const val google_services =
            "com.google.gms.google-services"
    }

    object Bundles
}