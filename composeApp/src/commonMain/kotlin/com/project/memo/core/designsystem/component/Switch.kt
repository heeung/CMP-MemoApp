package com.project.memo.core.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.project.memo.Res
import com.project.memo.core.designsystem.extention.noRippleClickable
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.icon_moon
import com.project.memo.icon_sun
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val thumbSize by animateIntAsState(
        targetValue = if (checked) 24 else 20
    )

    val animatedFloat by animateFloatAsState(
        targetValue = if (checked) 1f else -1f
    )

    Box(
        modifier = modifier
            .aspectRatio(1.6f)
            .border(
                width = 2.dp,
                color = when {
                    checked -> CustomColor.current.transparent
                    else -> CustomColor.current.unselectIconColor
                },
                shape = RoundedCornerShape(60.dp)
            )
            .background(
                color = when {
                    checked -> CustomColor.current.buttonColor
                    else -> CustomColor.current.transparent
                },
                shape = RoundedCornerShape(60.dp)
            )
            .noRippleClickable { onCheckedChange(!checked) }
            .padding(6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(thumbSize.dp)
                .align(BiasAlignment(animatedFloat, 0f))
                .background(
                    color = when {
                        checked -> CustomColor.current.buttonTextColor
                        else -> CustomColor.current.unselectIconColor
                    },
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                painter = if (!checked) painterResource(Res.drawable.icon_sun) else painterResource(Res.drawable.icon_moon),
//                contentDescription = null,
//                colorFilter = ColorFilter.tint(
//                    color = when {
//                        checked -> CustomColor.current.buttonColor
//                        else -> CustomColor.current.unselectIconColor
//                    }
//                )
//            )
//            SunMoonToggle(
//                checked = checked
//            )
        }
    }
}

@Composable
expect fun SunMoonToggle(
    modifier: Modifier = Modifier,
    checked: Boolean,
)