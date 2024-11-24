package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun Swipe() {
    val swipeState = rememberSwipeableState(0f)
    val endPosition = with(LocalDensity.current) { 80.dp.toPx() }
    val anchors = mapOf(0f to 0f, endPosition to 1f)
    Box(Modifier.width(200.dp).swipeable(
        state = swipeState,
        anchors = anchors,
        orientation = Orientation.Horizontal,
        thresholds = { from, to -> FractionalThreshold(0.5f) }
    ).background(Color.Yellow)) {
        val gradient = Brush.horizontalGradient(colors = listOf(Color.Black, Color.White, Color.Black))
        Box(Modifier.size(100.dp).offset {
            println(swipeState.currentValue)
            IntOffset(swipeState.offset.value.roundToInt(), 0)
        }.background(gradient))
    }
}

@Preview
@Composable
fun Compose21() {
    Swipe()
}