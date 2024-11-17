package x.android.samples.compose

import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import androidx.window.core.layout.WindowWidthSizeClass.Companion.EXPANDED
import androidx.window.core.layout.WindowWidthSizeClass.Companion.MEDIUM

@Composable
fun WindowSizeClass() {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthClass = windowSizeClass.windowWidthSizeClass
    when (widthClass) {
        COMPACT -> Text("COMPACT")
        MEDIUM -> Text("MEDIUM")
        EXPANDED -> Text("EXPANDED")
    }
}

@Composable
fun Compose09() {
    WindowSizeClass()
}