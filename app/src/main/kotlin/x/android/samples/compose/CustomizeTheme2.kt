package x.android.samples.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun YRippleTheme(content: @Composable () -> Unit) {
    val configuration = RippleConfiguration(
        color = Color.Green,
        rippleAlpha = RippleAlpha(
            pressedAlpha = 0.5f,
            draggedAlpha = 0f,
            focusedAlpha = 0f,
            hoveredAlpha = 0f
        )
    )
    MaterialTheme {
        CompositionLocalProvider(LocalRippleConfiguration provides configuration, content)
    }
}

@Preview
@Composable
fun Compose11() {
    YRippleTheme {
        Column(Modifier.fillMaxWidth().wrapContentHeight()) {
            Text("Hello")
            Button(onClick = {}) {
                Text("Hello")
            }
        }
    }
}