package gini.apps.giniclock.ui.screens

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import gini.apps.giniclock.data.Report
import kotlin.random.Random

class ReportsRepository(
    val service: Any,
    //From DTO to Domain
    val ServiceDataToBusinessData: Any
) {

    suspend fun getData(): List<Report> = coroutineScope {
        (1..10).map {
            delay(Random.nextLong(0, 200))
            Report(data = "$it")
        }
    }

}
