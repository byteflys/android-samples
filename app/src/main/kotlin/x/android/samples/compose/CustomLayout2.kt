package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset

class PaddingsModifier(
    private val padding: Dp = 0.dp
) : LayoutModifier {

    override fun MeasureScope.measure(measurable: Measurable, constraints: Constraints): MeasureResult {
        val paddingSpace = padding.roundToPx() * 2
        // reduce padding space from parent available space
        val tryConstrains = constraints.offset(-paddingSpace, -paddingSpace)
        // measure content size with reduced parent space
        val placeable = measurable.measure(tryConstrains)
        // correct size with min and max size limit form parent constraints
        val width = constraints.constrainWidth(placeable.width + paddingSpace)
        val height = constraints.constrainHeight(placeable.height + paddingSpace)
        // layout element position
        return layout(width, height) {
            placeable.place(padding.roundToPx(), padding.roundToPx())
        }
    }
}

fun Modifier.paddings(padding: Dp) = then(PaddingsModifier(padding))

@Preview
@Composable
fun CustomLayoutView2() {
    Text("A", Modifier.background(Color.Yellow).wrapContentSize().paddings(10.dp))
}