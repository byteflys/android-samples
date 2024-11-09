package x.android.samples.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.text.buildAnnotatedString

@Preview
@Composable
fun AnnotatedStringView() {
    Text(text = buildAnnotatedString {
        pushStyle(ParagraphStyle(lineHeight = TextUnit(2.0f, TextUnitType.Em)))
        pushStyle(SpanStyle(color = Color.Red))
        append("123456789")
        pop()
        pushStyle(SpanStyle(color = Color.Green))
        append("123456789")
        pop()
        pop()
        append("123456789")
    })
}

