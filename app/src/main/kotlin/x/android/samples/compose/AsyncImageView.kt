package x.android.samples.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage

@Preview
@Composable
fun AsyncImageView() {
    AsyncImage(model = "https://www.sanguosha.cn/new_index_pc/img/sgs_code.jpg", contentDescription = null)
}