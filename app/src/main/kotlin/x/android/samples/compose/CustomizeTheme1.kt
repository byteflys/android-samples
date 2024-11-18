package x.android.samples.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

val XColor = lightColorScheme(
    primary = Color.Red, onPrimary = Color.Yellow
)

val XShape = Shapes(
    large = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
)

val XTypography = Typography(
    labelLarge = TextStyle.Default.copy(color = Color.White, fontSize = TextUnit(48f, TextUnitType.Sp), fontWeight = FontWeight(800), fontStyle = FontStyle.Italic, fontFamily = FontFamily.Monospace)
)

@Composable
fun XTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = XColor, shapes = XShape, typography = XTypography, content = content)
}

@Preview
@Composable
fun Compose10() {
    XTheme {
        Column(Modifier.fillMaxWidth().wrapContentHeight()) {
            Text("Hello")
            Button(onClick = {}, shape = shapes.large) {
                Text("Hello")
            }
        }
    }
}