package x.android.samples.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Preview
@Composable
fun AsyncImageView() {
    val asyncImagePainter = rememberAsyncImagePainter("https://www.sanguosha.cn/new_index_pc/img/sgs_code.jpg")
    val interactionSource = remember { MutableInteractionSource() }
    println(asyncImagePainter)
    Image(
        painter = asyncImagePainter, contentDescription = null,
        modifier = Modifier.background(Color.Yellow).width(300.dp).height(300.dp)
            .clickable(interactionSource = interactionSource, indication = ripple(color = Color.Red)) {}
    )
}