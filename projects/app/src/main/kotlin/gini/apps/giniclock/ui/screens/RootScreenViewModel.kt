package gini.apps.giniclock.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RootScreenViewModel(
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val startingScreen = MutableStateFlow(ScreenDestinations.Test)

}

sealed class ScreenDestinations {
    object Test : ScreenDestinations()
    object Login : ScreenDestinations()
    object Timeline : ScreenDestinations()

    operator fun invoke() = toString()

    override fun toString(): String {
        return this.javaClass.name
    }
}