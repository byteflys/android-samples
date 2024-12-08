package x.android.samples.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class User(val id: String, val name: String)

private val UserMapSaver = mapSaver(
    save = { mapOf("id" to it.id, "name" to it.name) },
    restore = {
        val id = it["id"] as String
        val name = it["name"] as String
        User(id, name)
    }
)

@Composable
private fun Temp() {
    var user by rememberSaveable(stateSaver = UserMapSaver) { mutableStateOf(User("1", "A")) }
    Text("${user.name}")
    Button(onClick = {
        user = User("2", "B")
    }, Modifier.width(100.dp).height(50.dp)) { }
}

@Preview
@Composable
fun Compose42() {
    Temp()
}