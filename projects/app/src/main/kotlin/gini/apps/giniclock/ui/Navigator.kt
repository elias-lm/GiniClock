package gini.apps.giniclock.ui

import gini.apps.giniclock.ui.screens.ScreenDestinations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigator {

    private val destinationFlow = MutableSharedFlow<ScreenDestinations>(extraBufferCapacity = 1)
    var destination: Flow<ScreenDestinations> = destinationFlow.asSharedFlow()

    fun navigateTo(destination: ScreenDestinations) {
        destinationFlow.tryEmit(destination)
    }
}