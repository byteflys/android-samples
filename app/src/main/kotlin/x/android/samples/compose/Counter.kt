package x.android.samples.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun Counter() {
    var count1 by remember { mutableIntStateOf(0) }
    var count2 by remember { mutableIntStateOf(0) }
    val count by remember { derivedStateOf { count1 + count2 } }
}

@Preview
@Composable
fun Compose42() {
    Counter()
}