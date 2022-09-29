package gini.apps.giniclock.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import gini.apps.giniclock.data.Report

@Composable
fun ReportView(reportViewModel: ReportViewModel) {
    val uiState by reportViewModel.uiState.collectAsState()
    val report = uiState.report
    ReportView(report = report)
}

@Composable
fun ReportView(report: Report) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        val (startTime, endTime) = createRefs()

        Text(
            modifier = Modifier.constrainAs(startTime) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(endTime.start)
            },
            text = "Start Time: ${report.times.start}"
        )
        Text(
            modifier = Modifier.constrainAs(endTime) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(startTime.end)
                end.linkTo(parent.end)
            },
            text = "Data: ${report.data}"
        )

    }
}
