package x.android.samples.compose

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun AnimationComposition() {
    var uiState by remember { mutableStateOf(true) }
    val transition = updateTransition(uiState)
    val animateColor by transition.animateColor { state -> if (state) Color.Green else Color.Gray }
    val animateDp by transition.animateDp { state -> if (state) 200.dp else 50.dp }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { uiState = !uiState }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.width(animateDp).height(animateDp).background(animateColor))
    }
}

@Preview
@Composable
fun Compose34() {
    AnimationComposition()
}