package x.android.samples.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import x.android.commons.context.ActivityX.immersive

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        immersive()
        super.onCreate(savedInstanceState)
        setContent {
            RootView()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
fun RootView() {
    Text("hello")
}