package x.android.samples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

private val ConstrainScope.left get() = run { absoluteLeft }
private val ConstrainScope.right get() = run { absoluteRight }
private val ConstrainedLayoutReference.left get() = run { absoluteLeft }
private val ConstrainedLayoutReference.right get() = run { absoluteRight }

private fun createConstraintSet(guidelinePosition: Dp) = ConstraintSet {
    val (e1, e2, e3) = createRefsFor("e1", "e2", "e3")
    val guideline = createGuidelineFromTop(guidelinePosition)
    constrain(e1) {
        left.linkTo(parent.left)
        top.linkTo(parent.top)
    }
    constrain(e2) {
        left.linkTo(e1.right)
        top.linkTo(guideline)
    }
    constrain(e3) {
        top.linkTo(e2.bottom)
        left.linkTo(e1.left)
        right.linkTo(e2.right)
        width = Dimension.fillToConstraints
    }
}

@Composable
private fun ConstraintSet(modifier: Modifier) {
    val constrains = createConstraintSet(50.dp)
    ConstraintLayout(constrains, modifier) {
        Box(Modifier.layoutId("e1").width(100.dp).height(100.dp).background(Color.Yellow))
        Box(Modifier.layoutId("e2").width(100.dp).height(100.dp).background(Color.Green))
        Box(Modifier.layoutId("e3").width(100.dp).height(100.dp).background(Color.Cyan))
    }
}

@Preview
@Composable
fun Compose07() {
    ConstraintSet(Modifier.width(250.dp).height(250.dp).background(Color(0.2f, 0.2f, 0.2f, 0.2f)))
}