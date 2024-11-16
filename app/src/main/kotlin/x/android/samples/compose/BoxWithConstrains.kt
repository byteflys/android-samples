package x.android.samples.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Badge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

private val imagesInternal = listOf(
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803"
)

@Composable
private fun responsiveGallery(
    images: List<String> = imagesInternal,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier.wrapContentSize().background(Color.Red)) {
        val itemSpacing = 10.dp
        val itemWidth = 50.dp
        val visibleCount = maxWidth.div(itemWidth + itemSpacing).toInt().minus(1)
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.Yellow),
            horizontalArrangement = Arrangement.spacedBy(itemSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            images.take(visibleCount).forEach {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = null,
                    modifier = Modifier.width(itemWidth).aspectRatio(1f).background(Color.Green)
                )
            }
            val remainCount = images.size - visibleCount
            if (remainCount > 0) {
                Badge {
                    Text("+$remainCount")
                }
            }
        }
    }
}

@Preview
@Composable
fun Compose04() {
    responsiveGallery(modifier = Modifier.width(250.dp).height(100.dp))
}