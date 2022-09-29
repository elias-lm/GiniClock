package gini.apps.giniclock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun TestView(testViewModel: TestViewModel) {
    //Material "Parent" layout
    Scaffold {
        //Simple layout similar to android "LinearLayout" with "orientation=vertical"
        Column {

            val text1: String by testViewModel.text1display.collectAsState()
            //recomposition ("refresh") occurs everytime text1 is changed
            Text(text = "User Check: $text1")

            Button(onClick = {
                testViewModel.checkReadWriteUserMethods()
            }) {
                Text(text = "checkReadWriteUserMethods")
            }

            val text2: State<String> = testViewModel.text2display.collectAsState()
            //recomposition ("refresh") occurs everytime text2 is changed
            Text(text = "User Check: ${text2.value}")

            Button(onClick = {
                testViewModel.checkReadWriteReportMethods()
            }) {
                Text(text = "checkReadWriteReportMethods")
            }
        }
    }
}

