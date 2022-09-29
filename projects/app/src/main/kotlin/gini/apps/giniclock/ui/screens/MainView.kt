package gini.apps.giniclock.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import gini.apps.giniclock.ui.custom.FutureTimelineView
import gini.apps.giniclock.ui.custom.PastTimelineView
import gini.apps.giniclock.ui.views.ReportView
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainView(viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    FutureTimelineView(modifier = Modifier, uiState.futureReports)
    ReportView(reportViewModel = getViewModel {
        parametersOf(
            viewModel.savedStateHandle,
            uiState.currentReport
        )
    })
    PastTimelineView(modifier = Modifier, uiState.pastReports)
}