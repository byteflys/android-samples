package x.android.samples.compose

import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
private fun BasicAnimationClass() {
    var animateDp by remember { mutableStateOf(200.dp) }
    val animation = remember { TargetBasedAnimation(tween(3000), Dp.VectorConverter, 200.dp, 100.dp) }
    LaunchedEffect(animation) {
        val startTime = withFrameNanos { it }
        while (true) {
            val duration = withFrameNanos { it } - startTime
            animateDp = animation.getValueFromNanos(duration)
            if (duration > 3.toDuration(DurationUnit.SECONDS).inWholeNanoseconds) {
                break
            }
        }
    }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.width(animateDp).height(animateDp).background(Color.Yellow))
    }
}

@Preview
@Composable
fun Compose37() {
    BasicAnimationClass()
}