package x.android.samples.compose

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

// custom Modifier node
class ScaleAnimation(private val interactionSource: InteractionSource) : Modifier.Node(), DrawModifierNode {

    private var scaleCenter = Offset.Zero
    private val scalePercent = Animatable(1f)

    private suspend fun animateToPressed(pressPosition: Offset) {
        scaleCenter = pressPosition
        scalePercent.animateTo(0.9f, spring())
    }

    private suspend fun animateToNormal() {
        scalePercent.animateTo(1f, spring())
    }

    // override Modifier.Node
    override fun onAttach() {
        println("Modifier.Node onAttach")
        coroutineScope.launch {
            interactionSource.interactions.collectLatest { interaction ->
                println(interaction.javaClass.simpleName)
                when (interaction) {
                    is PressInteraction.Press -> animateToPressed(interaction.pressPosition)
                    is PressInteraction.Release -> animateToNormal()
                    is PressInteraction.Cancel -> animateToNormal()
                }
            }
        }
    }

    // override DrawModifierNode
    override fun ContentDrawScope.draw() {
        scale(
            scale = scalePercent.value, pivot = scaleCenter
        ) {
            this@draw.drawContent()
        }
    }
}

// indication effect
object ScaleIndication : IndicationNodeFactory {
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return ScaleAnimation(interactionSource)
    }
    override fun equals(other: Any?) = (other === this)
    override fun hashCode() = 0
}