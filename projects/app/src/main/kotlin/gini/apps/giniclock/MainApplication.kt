package gini.apps.giniclock

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import gini.apps.giniclock.koin.firebaseModule
import gini.apps.giniclock.koin.reposModule
import gini.apps.giniclock.koin.services
import gini.apps.giniclock.koin.viewModelsModule
import mad.dev.common.CommonClass
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SHARED_PREFERENCES = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        startKoin {
            androidContext(this@MainApplication)
            modules(
                viewModelsModule,
                reposModule,
                firebaseModule,
                services
            )

            CommonClass()
        }
    }

    companion object {
        lateinit var SHARED_PREFERENCES: SharedPreferences
    }
}

private const val SHARED_PREFERENCES_NAME = "CLOCKWISE"
public const val companyName = "giniApps"

