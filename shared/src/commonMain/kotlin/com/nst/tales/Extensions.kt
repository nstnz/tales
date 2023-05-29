package com.nst.tales

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import com.nst.tales.design.image.AnimationIterations
import com.nst.tales.design.image.AnimationType
import com.nst.tales.design.image.IconType
import com.nst.tales.design.image.ImageType

expect fun ByteArray.toImageBitmap(): ImageBitmap

expect fun getFont(): FontFamily

@Composable
expect fun AnimatedComponent(
    type: AnimationType,
    modifier: Modifier = Modifier,
    iterations: AnimationIterations = AnimationIterations.FixedCount(times = 1),
    speed: Float = 1F,
    isPlaying: Boolean = true
)

expect fun randomUUID(): String

expect fun getPainter(type: IconType): Painter

expect fun getPainter(type: ImageType): Painter
