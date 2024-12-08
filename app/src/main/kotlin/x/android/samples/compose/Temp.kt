package x.android.samples.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
private fun Temp() {
    var count by remember { mutableIntStateOf(1) }
    val onClick = {
        count = Random.nextInt(1, 3)
    }
    Button(onClick = onClick) { Text(count.toString()) }
}

@Preview
@Composable
fun Compose42() {
    Temp()
}