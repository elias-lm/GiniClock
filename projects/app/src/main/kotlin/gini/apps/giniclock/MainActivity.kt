package gini.apps.giniclock

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import gini.apps.giniclock.data.firebase.database.FirebaseDatabaseManager
import gini.apps.giniclock.data.firebase.database.company.FirebaseCompanyImpl
import gini.apps.giniclock.data.firebase.database.report.FirebaseReportImpl
import gini.apps.giniclock.data.firebase.database.user.FirebaseUserImpl
import gini.apps.giniclock.data.models.Report
import gini.apps.giniclock.ui.screens.RootScreen
import gini.apps.giniclock.ui.screens.RootScreenViewModel
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootScreenViewModel: RootScreenViewModel by stateViewModel()
        setContent {
            RootScreen(rootScreenViewModel)
        }
    }
}