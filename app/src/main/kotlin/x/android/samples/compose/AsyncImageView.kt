package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Preview
@Composable
fun AsyncImageView() {
    AsyncImage(
        model = "https://www.sanguosha.cn/new_index_pc/img/sgs_code.jpg", contentDescription = null,
        modifier = Modifier.background(Color.Yellow).width(300.dp).height(300.dp)
    )
}