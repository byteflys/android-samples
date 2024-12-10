package x.android.samples.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
private fun Counter() {
    var foregroundColor by remember { mutableStateOf(Color.Red) }
    val backgroundColor by produceState(Color.White) {
        delay(1000L)
        foregroundColor.let {
            value = Color(0.1f, it.red, it.green, it.blue)
        }
    }
}

@Preview
@Composable
fun Compose42() {
    Counter()
}