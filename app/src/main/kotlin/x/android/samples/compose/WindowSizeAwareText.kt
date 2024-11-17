package x.android.samples.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.toComposeRect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.toIntSize
import androidx.window.layout.WindowMetricsCalculator

@Composable
fun rememberWindowSize(): Size {
    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val windowMetrics = remember(configuration) {
        WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(context)
    }
    return windowMetrics.bounds.toComposeRect().size
}

@Composable
fun WindowSizeAwareText() {
    val windowSize = rememberWindowSize()
    Text("${windowSize.toIntSize().width}-${windowSize.toIntSize().height}")
}