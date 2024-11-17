package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

typealias ConstrainBlock = ConstrainScope.() -> Unit

val ConstrainScope.left get() = run { absoluteLeft }
val ConstrainScope.right get() = run { absoluteRight }
val ConstrainedLayoutReference.left get() = run { absoluteLeft }
val ConstrainedLayoutReference.right get() = run { absoluteRight }

@Composable
private fun ConstraintLayoutCompose(modifier: Modifier) {
    ConstraintLayout(modifier) {
        val (e1, e2, e3) = createRefs()
        val guideline = createGuidelineFromTop(50.dp)
        val constrain1: ConstrainBlock = {
            left.linkTo(parent.left)
            top.linkTo(parent.top)
        }
        val constrain2: ConstrainBlock = {
            left.linkTo(e1.right)
            top.linkTo(guideline)
        }
        val constrain3: ConstrainBlock = {
            top.linkTo(e2.bottom)
            left.linkTo(e1.left)
            right.linkTo(e2.right)
            width = Dimension.fillToConstraints
        }
        Box(Modifier.constrainAs(e1, constrain1).width(100.dp).height(100.dp).background(Color.Yellow))
        Box(Modifier.constrainAs(e2, constrain2).width(100.dp).height(100.dp).background(Color.Green))
        Box(Modifier.constrainAs(e3, constrain3).width(100.dp).height(100.dp).background(Color.Cyan))
    }
}

@Preview
@Composable
fun Compose06() {
    ConstraintLayoutCompose(Modifier.width(250.dp).height(250.dp).background(Color(0.2f, 0.2f, 0.2f, 0.2f)))
}