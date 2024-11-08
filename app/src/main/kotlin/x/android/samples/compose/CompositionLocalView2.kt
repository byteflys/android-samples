package x.android.samples.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.compositionLocalWithComputedDefaultOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

val ContentTextSize = compositionLocalOf { 10f }
val HeaderTextSize = compositionLocalWithComputedDefaultOf {
    ContentTextSize.currentValue + 2f
}

@Composable
fun printScopeValue(scopeName: String) {
    println("$scopeName ${ContentTextSize.current}")
    println("$scopeName ${HeaderTextSize.current}")
}

@Preview
@Composable
fun CompositionLocalView2() {
    printScopeValue("TOP")
    CompositionLocalProvider(
        ContentTextSize provides 20f
    ) {
        printScopeValue("Provider1")
        Column {
            Text(text = "Header1", fontSize = TextUnit(HeaderTextSize.current, TextUnitType.Sp))
            Text(text = "Content1", fontSize = TextUnit(HeaderTextSize.current, TextUnitType.Sp))
            CompositionLocalProvider(
                ContentTextSize provides 30f
            ) {
                printScopeValue("Provider2")
                Column {
                    Text(text = "Header2", fontSize = TextUnit(HeaderTextSize.current, TextUnitType.Sp))
                    Text(text = "Content2", fontSize = TextUnit(HeaderTextSize.current, TextUnitType.Sp))
                }
            }
        }
    }
}