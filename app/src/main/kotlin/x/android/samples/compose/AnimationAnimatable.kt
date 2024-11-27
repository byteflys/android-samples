package x.android.samples.compose

import androidx.compose.animation.Animatable
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
import androidx.compose.runtime.LaunchedEffect
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
private fun AnimatableContainer() {
    var uiState by remember { mutableStateOf(true) }
    val animatable = remember { Animatable(Color.Gray) }
    LaunchedEffect(uiState) {
        animatable.animateTo(if (uiState) Color.Yellow else Color.Green)
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { uiState = !uiState }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.width(200.dp).height(200.dp).background(animatable.value))
    }
}

@Preview
@Composable
fun Compose33() {
    AnimatableContainer()
}