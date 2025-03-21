package com.project.memo.core.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.theme.CustomFontFamily

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 14.sp,
    color: Color = CustomColor.current.textColor,
    textDecoration: TextDecoration? = null,
    fontFamily: FontFamily = CustomFontFamily.Medium,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = TextStyle(
        lineHeight = TextUnit.Unspecified
    )
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontSize = fontSize,
        textDecoration = textDecoration,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        style = style,
        overflow = TextOverflow.Ellipsis
    )
}