package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun ResizableBox() {
    val scrollState = rememberScrollState()
    val contentHeightInDp = 400.dp
    val contentHeight = with(LocalDensity.current) { contentHeightInDp.toPx() }
    val gradient = Brush.linearGradient(0f to Color.Black, 0.5f to Color.Red, 1f to Color.Black, start = Offset(0f, 0f), end = Offset(0f, contentHeight))
    Box(Modifier.background(Color.Yellow).width(500.dp).height(200.dp).verticalScroll(scrollState)) {
        Box(modifier = Modifier.background(gradient).width(400.dp).height(contentHeightInDp).align(Alignment.Center))
    }
}

@Preview
@Composable
fun Compose20() {
    ResizableBox()
}