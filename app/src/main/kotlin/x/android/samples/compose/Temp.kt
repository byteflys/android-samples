package x.android.samples.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import x.kotlin.commons.string.UUID

data class User(val id: String, val name: String)

@Composable
private fun Temp() {
    var id by remember { mutableStateOf("1") }
    var user by remember(id) {
        println("execute computation block")
        mutableStateOf(User("1", "A"))
    }
    Text("${user.name}", Modifier.graphicsLayer { println("recompose") })
    Button(onClick = {
        id = UUID.short()
    }, Modifier.width(100.dp).height(50.dp)) { }
    Button(onClick = {
        user = User("2", "B")
    }, Modifier.width(100.dp).height(50.dp)) { }
}

@Preview
@Composable
fun Compose42() {
    Temp()
}