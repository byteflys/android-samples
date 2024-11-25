package x.android.samples.compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
private fun Card(title: String, modifier: Modifier = Modifier) {
    Card(elevation = 16.dp, modifier = modifier.padding(10.dp)) {
        Text(text = title, fontSize = TextUnit(22f, TextUnitType.Sp), fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp).fillMaxWidth())
    }
}

@Composable
private fun NestedScroll() {
    val coroutineScope = rememberCoroutineScope()
    val scrollState1 = rememberScrollState()
    val scrollState2 = rememberScrollState()
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                coroutineScope.launch {
                    if (scrollState1.isScrollInProgress) {
                        val target = scrollState1.value.toFloat() / scrollState1.maxValue * scrollState2.maxValue
                        scrollState2.scrollTo(target.toInt())
                    } else {
                        val target = scrollState2.value.toFloat() / scrollState2.maxValue * scrollState1.maxValue
                        scrollState1.scrollTo(target.toInt())
                    }
                }
                return Offset.Zero
            }
        }
    }
    Column(Modifier.wrapContentSize().nestedScroll(nestedScrollConnection)) {
        Row(modifier = Modifier.horizontalScroll(scrollState1)) {
            repeat(20) { Card("${it + 1}") }
        }
        Column(modifier = Modifier.verticalScroll(scrollState2)) {
            repeat(20) { Card("${it + 1}") }
        }
    }
}

@Preview
@Composable
fun Compose22() {
    NestedScroll()
}