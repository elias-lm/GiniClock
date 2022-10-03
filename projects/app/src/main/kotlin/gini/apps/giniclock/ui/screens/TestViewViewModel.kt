package gini.apps.giniclock.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gini.apps.giniclock.data.firebase.database.FirebaseDatabaseManager
import gini.apps.giniclock.data.models.Report
import gini.apps.giniclock.ui.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TestViewViewModel(
    //injected by Koin
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
    //injected by Koin module named "firebaseModule" in file "KoinModules.kt"
    private val firebaseDatabaseManager: FirebaseDatabaseManager
) : ViewModel() {


    //surviving configuration change, process death
    val text1display = savedStateHandle.getStateFlow("text1", "Text 1")
    //**not** surviving configuration change, process death
    val text2display = MutableStateFlow("Text 2")

    var clickState = true
    fun checkReadWriteUserMethods() = viewModelScope.launch(Dispatchers.IO) { //code runs in coroutine
        firebaseDatabaseManager.createUser("dani", "ohadsaada93@gmail.com")
        if (clickState) {
            firebaseDatabaseManager.getProfile(
                "ohadsaada93@gmail.com".replace(
                    ".",
                    ""
                )
            ) { user ->
                savedStateHandle["text1"] = user.username + " " + user.email
            }
        } else {
            savedStateHandle["text1"] = "2 sinim im cinor"
        }
        clickState = clickState.not()
    }

    fun checkReadWriteReportMethods() = viewModelScope.launch(Dispatchers.IO) { //code runs in coroutine
        val report = Report(System.currentTimeMillis(), -1)
        val uIds = listOf("ohadsaada93@gmail.com".replace(".", ""))
        firebaseDatabaseManager.createReport(uIds, report)
        firebaseDatabaseManager.getAllReportsByUserId(uIds[0]) {
            text2display.value = it?.toString() ?: "null"
        }
    }

    fun toTimelineScreen() {
        //if logic than do
        navigator.navigateTo(ScreenDestinations.Timeline.Graph)
    }

}