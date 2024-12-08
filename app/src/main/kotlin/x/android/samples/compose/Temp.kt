package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine

@Composable
private fun Temp() {
    var key by remember { mutableIntStateOf(1) }
    var width by remember { mutableStateOf(100.dp) }
    Box(Modifier.width(width).height(50.dp).background(Color.Yellow)) {
        println("composable recomposed")
        LaunchedEffect(key) {
            println("coroutine launched")
            suspendCancellableCoroutine<Unit> {
                it.invokeOnCancellation { println("coroutine cancelled") }
            }
            while (true) delay(100L)
        }
    }
    Button(onClick = {
        width += 1.dp
    }, Modifier.width(100.dp).height(50.dp)) { }
    Button(onClick = {
        key++
    }, Modifier.width(100.dp).height(50.dp)) { }
}

@Preview
@Composable
fun Compose42() {
    Temp()
}