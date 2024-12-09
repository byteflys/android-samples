package x.android.samples.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun Counter() {
    var count by remember { mutableIntStateOf(0) }
    SideEffect {
        println("recomposed $count")
    }
    Button(onClick = { count++ }) {
        Text("$count")
    }
}

@Preview
@Composable
fun Compose42() {
    Counter()
}