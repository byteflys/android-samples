package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
private fun ResizableBox() {
    val contentHeightInDp = 400.dp
    val contentHeight = with(LocalDensity.current) { contentHeightInDp.toPx() }
    val gradient = Brush.linearGradient(0f to Color.Black, 0.5f to Color.Red, 1f to Color.Black, start = Offset(0f, 0f), end = Offset(0f, contentHeight))
    val scrollState = rememberScrollState()
    // verticalScroll(scrollState)
    // scrollable(scrollState, Orientation.Vertical)
    val outline = Outline.Rectangle(Rect(100f, 100f, 200f, 200f))
    val shape = object : Shape {
        override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density) = outline
    }
    Box(Modifier.background(Color.Yellow).width(500.dp).height(200.dp).scrollable(scrollState, Orientation.Vertical)) {
        Box(
            Modifier.width(400.dp).height(contentHeightInDp).requiredSize(400.dp, 400.dp).clip(shape).align(Alignment.Center).offset {
                println(scrollState.value)
                IntOffset(0, scrollState.value)
            }.background(gradient)
        )
    }
}

@Preview
@Composable
fun Compose20() {
    ResizableBox()
}