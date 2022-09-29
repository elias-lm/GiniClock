package gini.apps.giniclock.ui.views

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import gini.apps.giniclock.data.Report
import gini.apps.giniclock.ui.screens.ReportsRepository

class ReportViewModel(
    private val stateHandle: SavedStateHandle,
    private val reportsRepository: ReportsRepository,
    private val report: Report,
) : ViewModel() {

    val uiState = stateHandle.getStateFlow("reportUiState", ReportUiState(report))

    fun interactWithMe() {
        report.data = "Interacted"
        stateHandle["reportUiState"] = uiState.value.copy(report = report)
    }
}

@kotlinx.serialization.Serializable
data class ReportUiState(val report: Report)