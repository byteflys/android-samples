package x.android.samples.compose

import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import x.android.commons.util.ViewX.setLayoutParams

@Composable
private fun AndroidViewComposable() {
    AndroidView(modifier = Modifier.fillMaxSize(), factory = { context ->
        val view = TextView(context)
        view.text = "Hello World"
        view.setLayoutParams {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.MATCH_PARENT
        }
        view.gravity = Gravity.CENTER
        return@AndroidView view
    })
}

@Preview
@Composable
fun Compose42() {
    AndroidViewComposable()
}