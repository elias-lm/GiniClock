package gini.apps.giniclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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