package x.android.samples.compose

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun CrossFade() {
    var state by remember { mutableIntStateOf(0) }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { state = (state + 1) % 2 }) { Text("Change State") }
        Crossfade(state, animationSpec = tween(durationMillis = 1000, delayMillis = 300)) { state ->
            if (state == 0)
                Box(Modifier.width(200.dp).height(100.dp).background(Color.Yellow))
            else
                Box(Modifier.width(200.dp).height(100.dp).background(Color.Red))
        }
    }
}

@Preview
@Composable
fun Compose30() {
    CrossFade()
}