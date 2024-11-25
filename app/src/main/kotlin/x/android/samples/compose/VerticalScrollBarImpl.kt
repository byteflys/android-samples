package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

private val parentWidth = 300.dp
private val parentHeight = 200.dp
private val contentWidth = 100.dp
private val contentHeight = 400.dp

class RectOutlineShape(val left: Float, val top: Float, val width: Float, val height: Float) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ) = Outline.Rectangle(Rect(left, top, left + width, top + height))
}

@Composable
private fun VerticalScrollBarImpl() {
    with(LocalDensity.current) {
        val gradient = Brush.linearGradient(0f to Color.Black, 0.5f to Color.Red, 1f to Color.Black, start = Offset(0f, 0f), end = Offset(0f, contentHeight.toPx()))
        var offset by remember { mutableFloatStateOf(0f) }
        val scrollState = rememberScrollableState { delta ->
            offset = (offset + delta).coerceIn(parentHeight.minus(contentHeight).toPx(), 0f)
            println("$offset $delta")
            return@rememberScrollableState delta
        }
        val clipOutline = RectOutlineShape(0f, contentHeight.minus(parentHeight).toPx() / 2, contentWidth.toPx(), parentHeight.toPx())
        Box(Modifier.background(Color.Yellow).width(parentWidth).height(parentHeight).scrollable(scrollState, Orientation.Vertical)) {
            Box(
                Modifier.align(Alignment.Center).requiredSize(contentWidth, contentHeight).clip(clipOutline)
                    .offset { IntOffset(0, clipOutline.top.toInt()) }
                    .offset { IntOffset(0, offset.toInt()) }
                    .background(gradient)
            )
        }
    }
}

@Preview
@Composable
fun Compose20() {
    VerticalScrollBarImpl()
}