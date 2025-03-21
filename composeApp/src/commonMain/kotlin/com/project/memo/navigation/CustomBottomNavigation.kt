package com.project.memo.navigation

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.memo.core.designsystem.component.CustomText
import com.project.memo.core.designsystem.extention.noRippleClickable
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.component.SpH
import com.project.memo.core.designsystem.theme.CustomFontFamily

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    label: String,
    iconPainter: Painter,
    selected: Boolean,
    onClick: () -> Unit
) {
    val animatedTextHeight by animateIntAsState(
        targetValue = if (selected) 12 else 0
    )

    val animatedIconSize by animateIntAsState(
        targetValue = if (selected) 24 else 22
    )

    Box(
        modifier = modifier
            .noRippleClickable(interactionSource = interactionSource) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(animatedIconSize.dp),
                painter = iconPainter,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = when {
                    selected -> CustomColor.current.selectedIconColor
                    else -> CustomColor.current.unselectIconColor
                })
            )
            if (selected) { SpH(4.dp) }
            CustomText(
                modifier = Modifier
                    .height(animatedTextHeight.dp),
                text = label,
                fontSize = 12.sp,
                fontFamily = CustomFontFamily.Bold,
                color = when {
                    selected -> CustomColor.current.selectedIconColor
                    else -> CustomColor.current.unselectIconColor
                }
            )
        }
    }
}