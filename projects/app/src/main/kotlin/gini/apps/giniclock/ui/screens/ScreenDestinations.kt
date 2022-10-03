package gini.apps.giniclock.ui.screens

sealed class ScreenDestinations(val route: String) {

    sealed class Login(subRoute: String) : ScreenDestinations("$route/$subRoute") {
        object Graph : Login("")
        object Main : Login("main")
        companion object {
            val route = "login"
        }
    }

    sealed class Timeline(subRoute: String) : ScreenDestinations("$route/$subRoute") {
        object Graph : Timeline("")
        object Main : Timeline("main")
        companion object {
            val route = "timeline"
        }
    }

    sealed class Test(subRoute: String) : ScreenDestinations("$route/$subRoute") {
        object Graph : Test("")
        object Main : Test("main")
        companion object {
            val route = "test"
        }
    }


}