package x.android.samples.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.rememberAsyncImagePainter

@Composable
private fun ResizableImage() {
    val scrollState = rememberScrollState()
    Box(Modifier.background(Color.Yellow).width(200.dp).height(200.dp).graphicsLayer { clip = false }) {
        val asyncImagePainter = rememberAsyncImagePainter(
            "https://www.sanguosha.cn/new_index_pc/img/sgs_code.jpg",
            ImageLoader.Builder(LocalContext.current).build()
        )
        Image(painter = asyncImagePainter, contentDescription = null, modifier = Modifier.wrapContentSize(unbounded = true), contentScale = ContentScale.FillBounds)
    }
}

@Preview
@Composable
fun Compose20() {
    ResizableImage()
}