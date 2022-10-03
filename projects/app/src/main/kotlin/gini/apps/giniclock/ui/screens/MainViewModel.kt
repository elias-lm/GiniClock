package gini.apps.giniclock.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import gini.apps.giniclock.data.Report
import gini.apps.giniclock.ui.Navigator

class MainViewModel(
     val savedStateHandle: SavedStateHandle,
     val navigator: Navigator,
    private val reportsRepo: ReportsRepository
) : ViewModel() {

    val uiState = savedStateHandle.getStateFlow("reports", MainViewState())

    init {
        viewModelScope.launch(Dispatchers.IO) {
//            savedStateHandle["reports"] = reportsRepo.getData().toMainViewState()
        }
    }

}

private fun List<Report>.toMainViewState(): MainViewState {
    val futureReports = mutableListOf<Report>()
    var currentReport = Report()
    val pastReports = mutableListOf<Report>()

    val now = Clock.System.now().toLocalDateTime(TimeZone.UTC)

    forEach { //TODO
        if (it.times.start < now && it.times.end != null && it.times.end < now) {
            pastReports + it
        } else if (it.times.start < now && it.times.end == null) {
            currentReport = it
        } else if(it.times.start > now) {
            futureReports + it
        }
    }

    return MainViewState(
        futureReports = futureReports,
        currentReport = currentReport,
        pastReports = pastReports
    )
}

@kotlinx.serialization.Serializable
data class MainViewState(
    val futureReports: List<Report> = emptyList(),
    val currentReport: Report = Report(),
    val pastReports: List<Report> = emptyList()
)