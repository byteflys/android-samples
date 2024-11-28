package x.android.samples.compose

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("RestrictedApi")
@Composable
private fun InfiniteAnimation() {
    val transition = rememberInfiniteTransition()
    val animateColor by transition.animateColor(Color.Red, Color.Green, infiniteRepeatable(tween(1000), RepeatMode.Reverse))
    val animateDp by transition.animateValue(200.dp, 100.dp, Dp.VectorConverter, infiniteRepeatable(tween(1000), RepeatMode.Reverse))
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.width(animateDp).height(animateDp).background(animateColor))
    }
}

@Preview
@Composable
fun Compose36() {
    InfiniteAnimation()
}