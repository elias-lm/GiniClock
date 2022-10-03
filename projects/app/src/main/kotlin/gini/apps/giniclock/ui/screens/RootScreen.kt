package gini.apps.giniclock.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import gini.apps.giniclock.ui.theme.MaterialTheme
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RootScreen(rootScreenViewModel: RootScreenViewModel) {

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    LaunchedEffect("navigation") {
        rootScreenViewModel.navigator.destination.collect {
            navController.navigate(it.route)
        }
    }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = topAppBar(),
        ) {
            NavHost(
                navController = navController,
                startDestination = ScreenDestinations.Test.Graph.route
            ) {
                navigation(
                    startDestination = ScreenDestinations.Test.Main.route,
                    route = ScreenDestinations.Test.Graph.route
                ) {
                    composable(route = ScreenDestinations.Test.Main.route) {
                        val testViewViewModel: TestViewViewModel =
                            getViewModel { parametersOf(rootScreenViewModel.savedStateHandle) }
                        TestView(testViewViewModel)
                    }
                }
                navigation(
                    startDestination = ScreenDestinations.Login.Main.route,
                    route = ScreenDestinations.Login.Graph.route
                ) {
                    composable(route = ScreenDestinations.Login.Main.route) {

                    }
                }
                navigation(
                    startDestination = ScreenDestinations.Timeline.Main.route,
                    route = ScreenDestinations.Timeline.Graph.route
                ) {
                    composable(route = ScreenDestinations.Timeline.Main.route) {
                        val mainViewModel: MainViewModel =
                            getViewModel { parametersOf(rootScreenViewModel.savedStateHandle) }
                        MainView(mainViewModel)
                    }
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
