package com.nst.tales.design.image

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nst.tales.getPainter

@Composable
internal fun SimpleIcon(
    type: IconType,
    tint: Color,
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier,
        contentDescription = "",
        tint = tint,
        painter = getPainter(type)
    )
}