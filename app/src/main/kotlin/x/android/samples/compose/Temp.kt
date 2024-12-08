package x.android.samples.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun Temp() {
    var count1 by remember { mutableIntStateOf(1) }
    Button(onClick = { count1++ }, Modifier.width(200.dp).height(50.dp)) {
        if (count1 % 3 == 1) {
            var count2 by remember { mutableIntStateOf(1) }
            Text("$count1 $count2", Modifier.clickable { count2++ })
        }
    }
}

@Preview
@Composable
fun Compose42() {
    Temp()
}