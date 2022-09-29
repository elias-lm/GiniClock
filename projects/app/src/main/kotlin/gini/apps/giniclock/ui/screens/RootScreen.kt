package gini.apps.giniclock.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gini.apps.giniclock.ui.theme.MaterialTheme
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RootScreen(rootScreenViewModel: RootScreenViewModel) {

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = topAppBar(),
        ) {
            NavHost(
                navController = navController,
                startDestination = rootScreenViewModel.startingScreen.asStateFlow().value.toString()
//                when (rootScreenViewModel.startingScreen.asStateFlow().value as ScreenDestinations) {
//                    ScreenDestinations.Test -> TODO()
//                    ScreenDestinations.Login -> NavigationDestinations.Login
//                    ScreenDestinations.Timeline -> NavigationDestinations.Timeline
//                }
            ) {
                composable(route = ScreenDestinations.Test()) {
                    val testViewModel: TestViewModel =
                        getViewModel { parametersOf(rootScreenViewModel.savedStateHandle) }
                    TestView(testViewModel)
                }
                composable(route = ScreenDestinations.Login()) {

                }
                composable(route = ScreenDestinations.Timeline()) {
                    val mainViewModel: MainViewModel =
                        getViewModel { parametersOf(rootScreenViewModel.savedStateHandle) }
                    MainView(mainViewModel)
                }
            }
        }
    }

}

@Composable
fun topAppBar(): @Composable () -> Unit = {
    TopAppBar(
        title = {
            Text("Title Here")
        },
        actions = {
            Button(onClick = {}) {
                Text(text = "Click")
            }
        }
    )
}
