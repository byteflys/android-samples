package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun Counter(foregroundColor: Color, modifier: Modifier) {
    val foregroundColor by rememberUpdatedState(foregroundColor)
    val backgroundColor = remember(foregroundColor) {
        val origin = foregroundColor
        Color(origin.red, origin.green, origin.blue, 0.2f)
    }
    Box(modifier = modifier.background(backgroundColor)) {
        Text("1", color = foregroundColor)
    }
}

@Preview
@Composable
fun Compose42() {
    var foregroundColor by remember { mutableStateOf(Color.Red) }
    Counter(foregroundColor, Modifier.size(100.dp).clickable { foregroundColor = Color.Blue })
}