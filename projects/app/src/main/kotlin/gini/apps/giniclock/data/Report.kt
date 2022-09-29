package gini.apps.giniclock.data

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


@kotlinx.serialization.Serializable
data class Report(val times: ReportTimes = ReportTimes(), var data: String = "")

@kotlinx.serialization.Serializable
data class ReportTimes(
    val start: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC),
    val end: LocalDateTime? = null
)
