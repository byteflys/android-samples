package x.android.samples.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Preview
@Composable
fun AsyncImageView() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://www.sanguosha.cn/new_index_pc/img/sgs_code.jpg")
            .crossfade(true)
            .build(),
        contentDescription = null
    )
}