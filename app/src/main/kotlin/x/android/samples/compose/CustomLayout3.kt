package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.paddingBaseline(padding: Dp) = layout { measurable, constraints ->
    // measure content size
    val placeable = measurable.measure(constraints)
    // get baseline position in text
    val yBaseline = placeable[FirstBaseline]
    // compute text position in layout
    val y = padding.roundToPx() - yBaseline
    // layout element
    val width = placeable.width
    val height = placeable.height + y
    layout(width, height) {
        placeable.place(0, y)
    }
}

@Preview
@Composable
fun CustomLayoutView3() {
    Row {
        Text("A", Modifier.background(Color.Yellow).wrapContentSize().paddingBaseline(50.dp))
        Text("B", Modifier.background(Color.Green).wrapContentSize())
    }
}