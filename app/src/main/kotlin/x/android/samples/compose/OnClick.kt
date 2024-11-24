package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun ClickableItem() {
    Box(Modifier.background(Color.Yellow).clickable {
        println("Clicked")
    }) { Text("Hello") }
}

@Preview
@Composable
fun Compose15() {
    ClickableItem()
}