package com.nst.tales.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal object Gradients {

    @Composable
    fun background1() = Brush.verticalGradient(
        0.0f to AppTheme.colors.accent4(),
        0.7f to AppTheme.colors.background2()
    )

    @Composable
    fun pageEnd() = Brush.horizontalGradient(
        0.3f to AppTheme.colors.textLightDefault(),
        1f to Color(0xffe3e3e3)
    )

    @Composable
    fun pageStart() = Brush.horizontalGradient(
        0.3f to Color(0xfff9f9f9),
        1f to AppTheme.colors.textLightDefault(),
    )
}