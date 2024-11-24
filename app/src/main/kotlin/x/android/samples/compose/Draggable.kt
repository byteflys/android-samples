package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
private fun Draggable() {
    Box(Modifier.background(Color.Red).width(300.dp).height(200.dp)) {
        var offsetX by remember { mutableFloatStateOf(0f) }
        var parentWidth by remember { mutableFloatStateOf(0f) }
        var elementWidth by remember { mutableFloatStateOf(0f) }
        val minOffset by remember {
            derivedStateOf { (elementWidth - parentWidth) / 2 }
        }
        val maxOffset by remember {
            derivedStateOf { (parentWidth - elementWidth) / 2 }
        }
        Text(
            text = "Hello",
            modifier = Modifier.offset {
                println("$offsetX $minOffset $maxOffset")
                IntOffset(offsetX.coerceAtLeast(minOffset).coerceAtMost(maxOffset).roundToInt(), 0)
            }.draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetX = (offsetX + delta).coerceAtLeast(minOffset).coerceAtMost(maxOffset)
                }
            ).onGloballyPositioned { coordinates ->
                elementWidth = coordinates.size.width.toFloat()
                parentWidth = coordinates.parentLayoutCoordinates!!.size.width.toFloat()
            }.background(Color.Yellow).align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun Compose17() {
    Draggable()
}