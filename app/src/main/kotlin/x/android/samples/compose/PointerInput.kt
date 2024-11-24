package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun DetectGestures() {
    Box(Modifier.background(Color.Yellow).pointerInput(Unit) {
        detectTapGestures(
            onTap = { println("OnTap $it") },
            onDoubleTap = { println("onDoubleTap $it") },
            onPress = { println("onPress $it") },
            onLongPress = { println("onLongPress $it") }
        )
    }) { Text("Hello") }
}

@Preview
@Composable
fun Compose16() {
    DetectGestures()
}