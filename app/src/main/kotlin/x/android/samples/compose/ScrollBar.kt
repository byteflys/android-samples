package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun ScrollBar() {
    val gradient1 = Brush.verticalGradient(colors = listOf(Color.Red, Color.Yellow, Color.Red))
    val gradient2 = Brush.verticalGradient(colors = listOf(Color.Blue, Color.Green, Color.Blue))
    val gradient3 = Brush.verticalGradient(colors = listOf(Color.Black, Color.White, Color.Black))
    Box(Modifier.background(gradient1).width(400.dp).height(200.dp).verticalScroll(rememberScrollState())) {
        Column(Modifier.background(gradient2).width(300.dp).height(300.dp).align(Alignment.Center).verticalScroll(rememberScrollState())) {
            Box(Modifier.background(gradient3).width(200.dp).height(600.dp).align(Alignment.CenterHorizontally))
        }
    }
}

@Preview
@Composable
fun Compose19() {
    ScrollBar()
}