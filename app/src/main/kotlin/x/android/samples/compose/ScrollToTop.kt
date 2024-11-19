package x.android.samples.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

private val items = List(100) { (it + 100).toChar() }

@Preview
@Composable
fun Compose13() {
    Box(Modifier.fillMaxSize()) {
        val coroutineScope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val isAtTop = remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        LazyColumn(state = listState, modifier = Modifier.fillMaxWidth()) {
            items(items, key = { it }) { Text(it.toString()) }
        }
        AnimatedVisibility(visible = isAtTop.value, modifier = Modifier.align(Alignment.BottomEnd)) {
            Button(onClick = {
                coroutineScope.launch { listState.animateScrollToItem(0) }
            }) { Text("TOP") }
        }
    }
}