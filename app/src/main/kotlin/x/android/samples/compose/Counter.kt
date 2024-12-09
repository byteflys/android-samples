package x.android.samples.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
private fun Counter() {
    var count by remember { mutableIntStateOf(0) }
    DisposableEffect(count) {
        println("scope created")
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            while (true) delay(1000)
        }
        onDispose {
            println("scope disposed")
            job.cancel()
        }
    }
    Button(onClick = { }) { Text("1") }
    Button(onClick = { count++ }) { Text("2") }
}

@Preview
@Composable
fun Compose42() {
    Counter()
}