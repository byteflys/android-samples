package x.android.samples.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import kotlinx.coroutines.delay

// simulate max num returned by server
private const val maxPageNum = 15

// simulate http request
suspend fun loadHttpData(pageNum: Int, pageSize: Int): List<String> {
    delay(500)
    return List(5) { "Page-$pageNum : ${it + 1}" }
}

private val pagingSource = object : PagingSource<Int, String>() {

    // refresh all data
    override fun getRefreshKey(state: PagingState<Int, String>): Int {
        return 1
    }

    // load current page
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val pageNum = params.key ?: 1
        val pageSize = params.loadSize
        val data = loadHttpData(pageNum, pageSize)
        val preNum = if (pageNum <= 1) null else pageNum - 1
        val nextNum = if (pageNum >= maxPageNum) null else pageNum + 1
        return LoadResult.Page(
            data = data,
            prevKey = preNum,
            nextKey = nextNum
        )
    }
}

private val pagingFlow = Pager(
    config = PagingConfig(pageSize = 5),
    initialKey = 1,
    pagingSourceFactory = { pagingSource }
).flow

@Composable
private fun PagingLazyColumn(pagingItems: LazyPagingItems<String>, modifier: Modifier = Modifier.fillMaxWidth()) {
    when (pagingItems.loadState.refresh) {
        is LoadState.Loading -> Text("Loading")
        is LoadState.Error -> Text("Error")
        is LoadState.NotLoading -> {
            LazyColumn(modifier = modifier) {
                items(
                    pagingItems.itemCount,
                    key = pagingItems.itemKey { it }
                ) { index ->
                    val data = pagingItems[index].orEmpty()
                    Text(data)
                }
            }
        }
        else -> Text("???")
    }
}

@Preview
@Composable
fun Compose14() {
    val pagingItems = pagingFlow.collectAsLazyPagingItems()
    PagingLazyColumn(pagingItems)
}