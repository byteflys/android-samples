package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
private fun Draggable() {
    Box(Modifier.background(Color.Red).width(300.dp).height(200.dp)) {
        var offsetX by remember { mutableFloatStateOf(0f) }
        var offsetY by remember { mutableFloatStateOf(0f) }
        val minOffset = (-100).dp
        val maxOffset = 100.dp
        Box(
            Modifier.width(100.dp).height(100.dp).offset {
                IntOffset(
                    offsetX.coerceAtLeast(minOffset.toPx()).coerceAtMost(maxOffset.toPx()).roundToInt(),
                    offsetY.coerceAtLeast(minOffset.toPx()).coerceAtMost(maxOffset.toPx()).roundToInt()
                )
            }.pointerInput(Unit) {
                detectDragGestures { change, amount ->
                    change.consume()
                    offsetX = (offsetX + amount.x).coerceAtLeast(minOffset.toPx()).coerceAtMost(maxOffset.toPx())
                    offsetY = (offsetY + amount.y).coerceAtLeast(minOffset.toPx()).coerceAtMost(maxOffset.toPx())
                }
            }.background(Color.Yellow).align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun Compose18() {
    Draggable()
}