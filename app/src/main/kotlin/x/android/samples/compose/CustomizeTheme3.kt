package x.android.samples.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val ZColors = staticCompositionLocalOf { lightColors() }
val ZShapes = staticCompositionLocalOf { Shapes() }

@Composable
fun ZTheme(
    colors: Colors = lightColors(primary = Color.Red),
    shapes: Shapes = Shapes(large = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
    content: @Composable () -> Unit
) {
    val colors = remember { colors.copy() }
    val shapes = remember { shapes.copy() }
    CompositionLocalProvider(ZColors provides colors, ZShapes provides shapes, content = content)
}

object ZTheme {
    val colors: Colors
        @Composable get() = ZColors.current
    val shapes: Shapes
        @Composable get() = ZShapes.current
}

@Preview
@Composable
fun Compose12() {
    ZTheme {
        Column(Modifier.fillMaxWidth().wrapContentHeight()) {
            Text("Hello", color = ZTheme.colors.primary)
            Button(onClick = {}, shape = ZTheme.shapes.large) {
                Text("Hello")
            }
        }
    }
}