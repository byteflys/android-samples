package x.android.samples.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun CustomLayout1(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // measurables : child contents
    // constrains : parent constrains
    Layout(content, modifier) { measurables, constrains ->
        // measure child size
        val placeables = measurables.map { it.measure(constrains) }
        // layout child position, with parent constrains
        layout(constrains.maxWidth, constrains.maxHeight) {
            var y = 0
            placeables.forEach {
                it.place(0, y)
                y += it.height
            }
        }
    }
}

@Preview
@Composable
fun CustomLayoutView1() {
    CustomLayout1 {
        Text("A", Modifier.background(Color.Yellow).width(100.dp).height(50.dp))
        Text("B", Modifier.background(Color.Green).width(100.dp).height(50.dp))
        Text("C", Modifier.background(Color.Cyan).width(100.dp).height(50.dp))
    }
}