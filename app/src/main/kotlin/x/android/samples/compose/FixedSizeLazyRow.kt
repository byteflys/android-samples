package x.android.samples.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

private val imagesInternal = listOf(
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803?t=1",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803?t=2",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803?t=3",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803?t=4",
    "https://images.unsplash.com/photo-1511044568932-338cba0ad803?t=5"
)

@Composable
private fun FixedSizeLazyRow(
    images: List<String> = imagesInternal,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier.background(Color.Red), contentAlignment = Alignment.Center) {
        val itemSpacing = 10.dp
        var itemWidth = 50.dp
        val visibleCount = maxWidth.div(itemWidth + itemSpacing).toInt()
        itemWidth = maxWidth.minus(itemSpacing.times(visibleCount - 1)).div(visibleCount)
        val items = remember { images }
        LazyRow(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().background(Color.Yellow),
            horizontalArrangement = Arrangement.spacedBy(itemSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items, key = { it }) {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.width(itemWidth).aspectRatio(1f).background(Color.Green)
                )
            }
        }
    }
}

@Preview
@Composable
fun Compose05() {
    FixedSizeLazyRow(modifier = Modifier.width(250.dp).height(100.dp))
}