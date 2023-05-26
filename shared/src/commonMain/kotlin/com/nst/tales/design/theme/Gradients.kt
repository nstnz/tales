package com.nst.tales.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.nst.tales.design.theme.AppTheme

internal object Gradients {

    @Composable
    fun background1() = Brush.verticalGradient(
        0.0f to AppTheme.colors.accent4(),
        0.7f to AppTheme.colors.background2()
    )
}