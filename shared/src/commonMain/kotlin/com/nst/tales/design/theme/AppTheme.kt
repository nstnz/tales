package com.nst.tales.design.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.nst.tales.design.theme.Colors
import com.nst.tales.design.theme.Elevations
import com.nst.tales.design.theme.Gradients
import com.nst.tales.design.theme.Indents
import com.nst.tales.design.theme.Shapes
import com.nst.tales.design.theme.Typography
import com.nst.tales.design.theme.toMaterialColors

internal val LocalTypography = staticCompositionLocalOf<Typography> {
    throw IllegalStateException("No Typography provided")
}

internal val LocalColors = staticCompositionLocalOf<Colors> {
    throw IllegalStateException("No Colors provided")
}

internal val LocalIndents = staticCompositionLocalOf<Indents> {
    throw IllegalStateException("No Indents provided")
}

internal val LocalGradients = staticCompositionLocalOf<Gradients> {
    throw IllegalStateException("No Gradients provided")
}

internal val LocalShapes = staticCompositionLocalOf<Shapes> {
    throw IllegalStateException("No Shapes provided")
}

internal val LocalElevations = staticCompositionLocalOf<Elevations> {
    throw IllegalStateException("No Elevations provided")
}

internal object AppTheme {

    val colors: Colors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = LocalTypography.current

    val indents: Indents
        @Composable
        get() = LocalIndents.current

    val elevations: Elevations
        @Composable
        get() = LocalElevations.current

    val gradients: Gradients
        @Composable
        get() = LocalGradients.current

    val shapes: Shapes
        @Composable
        get() = LocalShapes.current
}

@Composable
internal fun AppTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalTypography provides Typography,
        LocalColors provides Colors,
        LocalIndents provides Indents(),
        LocalGradients provides Gradients,
        LocalShapes provides Shapes(),
        LocalElevations provides Elevations(),
    ) {
        MaterialTheme(
            content = content,
            colors = Colors.toMaterialColors(),
        )
    }
}