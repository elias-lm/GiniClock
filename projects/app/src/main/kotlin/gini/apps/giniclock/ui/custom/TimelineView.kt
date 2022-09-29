package gini.apps.giniclock.ui.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gini.apps.giniclock.data.Report
import gini.apps.giniclock.ui.views.ReportView

@Composable
fun FutureTimelineView(modifier: Modifier = Modifier, reports: List<Report>) {
    Text("Future Reports START")
    TimelineView(modifier = modifier, reports = reports)
    Text("Future Reports END")
}

@Composable
fun PastTimelineView(modifier: Modifier = Modifier, reports: List<Report>) {
    Text("Past Reports START")
    TimelineView(modifier = modifier, reports = reports)
    Text("Past Reports END")
}

@Composable
fun TimelineView(modifier: Modifier = Modifier, reports: List<Report>) {
    Surface(modifier = Modifier.height(300.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            items(reports) {
                ReportView(it)
                Divider()
            }
        }
    }
}
