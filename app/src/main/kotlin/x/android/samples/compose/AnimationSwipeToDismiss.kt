package x.android.samples.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

private fun Modifier.swipeToDismiss(onDismiss: () -> Unit): Modifier = composed {
    val offsetXAnimatable = remember { Animatable(0f) }
    pointerInput(Unit) {
        val decay = splineBasedDecay<Float>(this)
        coroutineScope {
            while (true) {
                val pointerId = awaitPointerEventScope { awaitFirstDown().id }
                val velocityTracker = VelocityTracker()
                offsetXAnimatable.stop()
                awaitPointerEventScope {
                    // suspend until pointer release
                    horizontalDrag(pointerId) { change ->
                        velocityTracker.addPosition(change.uptimeMillis, change.position)
                        launch { offsetXAnimatable.snapTo(offsetXAnimatable.value + change.positionChange().x) }
                    }
                }
                val velocity = velocityTracker.calculateVelocity().x
                val targetOffsetX = decay.calculateTargetValue(offsetXAnimatable.value, velocity)
                offsetXAnimatable.updateBounds(-size.width.toFloat(), size.width.toFloat())
                launch {
                    if (targetOffsetX.absoluteValue <= size.width)
                        offsetXAnimatable.animateTo(targetValue = 0f, initialVelocity = velocity)
                    else {
                        offsetXAnimatable.animateDecay(velocity, decay)
                        onDismiss()
                    }
                }
            }
        }
    }.offset { IntOffset(offsetXAnimatable.value.roundToInt(), 0) }
}

@Composable
private fun SwipeToDismiss() {
    Column(Modifier.width(200.dp).height(200.dp).background(Color.Red), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        var visibilityState by remember { mutableStateOf(true) }
        AnimatedVisibility(visibilityState) {
            Box(Modifier.width(200.dp).height(200.dp).swipeToDismiss { visibilityState = false }.background(Color.Yellow))
        }
    }
}

@Preview
@Composable
fun Compose40() {
    SwipeToDismiss()
}