package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Compose04() {
    Row {
        Text("A", Modifier.background(Color.Yellow).wrapContentSize().paddingBaseline(50.dp))
        Text("B", Modifier.background(Color.Green).wrapContentSize())
    }
}