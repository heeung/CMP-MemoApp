package com.project.memo.core.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import com.project.memo.core.designsystem.extention.noRippleClickable

@Composable
internal fun CustomButton(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    normalColor: Color,
    pressColor: Color,
    hoverColor: Color? = null,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(10.dp),
    content: @Composable (RowScope.() -> Unit),
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()

    val animatedColor by animateColorAsState(
        targetValue = when {
            isPressed -> pressColor
            isHovered -> hoverColor ?: normalColor
            else -> normalColor
        }
    )

    Row(
        modifier = modifier
            .background(
                color = animatedColor,
                shape = shape
            )
            .pointerHoverIcon(icon = PointerIcon.Hand)
            .noRippleClickable(
                interactionSource = interactionSource
            ) { onClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        content()
    }
}