package gini.apps.giniclock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import gini.apps.giniclock.ui.CollectEffect
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun TestView(viewModel: TestViewViewModel) {

    //Material "Parent" layout
    Scaffold() {
        //Simple layout similar to android "LinearLayout" with "orientation=vertical"
        Column {
            val text1: String by viewModel.text1display.collectAsState()
            //recomposition ("refresh") occurs everytime text1 is changed
            Text(text = "User Check: $text1")
            Button(onClick = {
                viewModel.checkReadWriteUserMethods()
            }) {
                Text(text = "checkReadWriteUserMethods")
            }

            val text2: State<String> = viewModel.text2display.collectAsState()
            //recomposition ("refresh") occurs everytime text2 is changed
            Text(text = "User Check: ${text2.value}")
            Button(onClick = {
                viewModel.checkReadWriteReportMethods()
            }) {
                Text(text = "checkReadWriteReportMethods")
            }

            Text(text = "Navigate To Timeline")
            Button(onClick = {
                viewModel.toTimelineScreen()
            }) {
                Text(text = "To Timeline Screen")
            }


        }
    }
}

class Event<T>(private val t: T) {
    private var hasUsed: Boolean = false

    fun peekContent(): T = t

    fun use(): T? = if (hasUsed) null else {
        hasUsed = true
        t
    }
}
