package x.android.samples.compose

import android.os.Parcelable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val id: String, val name: String) : Parcelable

@Composable
private fun Temp() {
    var user by rememberSaveable { mutableStateOf(User("1", "A")) }
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