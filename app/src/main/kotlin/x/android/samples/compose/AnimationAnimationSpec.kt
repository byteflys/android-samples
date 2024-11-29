package x.android.samples.compose

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.StartOffsetType
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

typealias Spec = @Composable Transition.Segment<*>.() -> FiniteAnimationSpec<Dp>

@Composable
private fun AnimationSpec() {
    val state = remember { MutableTransitionState(20.dp) }
    val transition = rememberTransition(state)
    val spec1: Spec = { spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessVeryLow) }
    val spec2: Spec = { tween(durationMillis = 1000, delayMillis = 200, easing = FastOutSlowInEasing) }
    val spec3: Spec = {
        keyframes {
            if (state.targetState == 20.dp) {
                20.dp at 0
                return@keyframes
            }
            durationMillis = 5000
            0.dp at 0
            100.dp at 2000 using FastOutLinearInEasing
            100.dp at 3000
            200.dp at 5000 using LinearEasing
        }
    }
    val spec4: Spec = {
        repeatable(
            iterations = 5,
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse,
            initialStartOffset = StartOffset(1000, StartOffsetType.FastForward)
        )
    }
    val spec5 = infiniteRepeatable(
        animation = tween<Dp>(durationMillis = 1000),
        repeatMode = RepeatMode.Reverse
    )
    val spec6: Spec = { snap(delayMillis = 500) }
    val animatedDp1 by transition.animateDp(spec1) { it }
    val animatedDp2 by transition.animateDp(spec2) { it }
    val animatedDp3 by transition.animateDp(spec3) { it }
    val animatedDp4 by transition.animateDp(spec4) { it }
    val infiniteState = remember { MutableTransitionState(20.dp) }
    LaunchedEffect(Unit) {
        infiniteState.targetState = 200.dp
    }
    val animatedDp5 by animateDpAsState(infiniteState.targetState, animationSpec = spec5)
    val animatedDp6 by transition.animateDp(spec6) { it }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            state.targetState = if (state.targetState == 20.dp) 200.dp else 20.dp
        }) { Text("GO") }
        Box(Modifier.width(animatedDp1).height(40.dp).background(Color.Yellow))
        Box(Modifier.width(animatedDp2).height(40.dp).background(Color.Green))
        Box(Modifier.width(animatedDp3).height(40.dp).background(Color.Red))
        Box(Modifier.width(animatedDp4).height(40.dp).background(Color.Blue))
        Box(Modifier.width(animatedDp5).height(40.dp).background(Color.White))
        Box(Modifier.width(animatedDp6).height(40.dp).background(Color.Black))
    }
}

@Preview
@Composable
fun Compose41() {
    AnimationSpec()
}