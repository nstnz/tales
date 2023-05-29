package com.nst.tales.design.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.transparent
import com.nst.tales.getPainter

@Composable
internal fun SimpleImage(
    type: ImageType,
    modifier: Modifier = Modifier,
    colorMultiply: Color? = null
) {
    Image(
        painter = getPainter(type),
        contentDescription = "",
        modifier = modifier,
        contentScale = ContentScale.FillBounds,
        colorFilter = colorMultiply?.let {
            ColorFilter.lighting(
                multiply = it,
                add = AppTheme.colors.transparent()
            )
        }
    )
}