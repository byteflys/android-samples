package x.android.samples.compose

import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalTransitionApi::class)
private fun CreateChildTransition() {
    var scaleState by remember { mutableStateOf(true) }
    val scaleTransition = updateTransition(scaleState)
    val transitionSpec: @Composable Transition.Segment<*>.() -> FiniteAnimationSpec<Dp> = { tween(durationMillis = 5000) }
    val boxSizeTransition = scaleTransition.createChildTransition { scaled -> if (scaled) 250.dp else 80.dp }
    val fontSizeTransition = boxSizeTransition.createChildTransition { boxSize -> boxSize / 5 }
    val boxSize by boxSizeTransition.animateDp(transitionSpec) { it }
    val fontSize by fontSizeTransition.animateDp(transitionSpec) { it }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { scaleState = !scaleState }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.width(boxSize).height(boxSize).background(Color.Yellow)) {
            Text("Hello", Modifier.align(Alignment.Center), fontSize = TextUnit(fontSize.value, TextUnitType.Sp))
        }
    }
}

@Preview
@Composable
fun Compose39() {
    CreateChildTransition()
}