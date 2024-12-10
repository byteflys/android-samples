package x.android.samples.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
private fun Counter() {
    val coroutineScope = rememberCoroutineScope()
    var count by remember { mutableIntStateOf(0) }
    val onClick: () -> Unit = {
        coroutineScope.launch {
            delay(3000)
            count++
        }
    }
    Button(onClick = onClick) {
        Text("$count")
    }
}

@Preview
@Composable
fun Compose42() {
    Counter()
}