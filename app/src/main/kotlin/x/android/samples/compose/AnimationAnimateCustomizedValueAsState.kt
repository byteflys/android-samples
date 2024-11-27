package x.android.samples.compose

import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private class CustomValue {
    var width = 0f
    var height = 0f
    var grayscale = Color.Blue
    var shadow = 1f
}

private val CustomValueConvertor: TwoWayConverter<CustomValue, AnimationVector4D> = TwoWayConverter({
    AnimationVector4D(it.width, it.height, it.grayscale.red, it.shadow)
}, {
    CustomValue().apply {
        width = it.v1
        height = it.v2
        grayscale = Color(it.v3, it.v3, it.v3)
        shadow = it.v4
    }
})

private val uiState1 = CustomValue().apply {
    width = 300f
    height = 300f
    grayscale = Color.White
    shadow = 11f
}

private val uiState2 = CustomValue().apply {
    width = 200f
    height = 200f
    grayscale = Color.Black
    shadow = 10f
}

@Composable
private fun AnimateCustomizedValueAsState() {
    var uiState by remember { mutableStateOf(uiState1) }
    val animatedValue by animateValueAsState(uiState, CustomValueConvertor)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            uiState = if (uiState == uiState1) uiState2 else uiState1
        }) { Text("Change State") }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.shadow(animatedValue.shadow.dp).width(animatedValue.width.dp).height(animatedValue.height.dp).background(animatedValue.grayscale))
    }
}

@Preview
@Composable
fun Compose32() {
    AnimateCustomizedValueAsState()
}