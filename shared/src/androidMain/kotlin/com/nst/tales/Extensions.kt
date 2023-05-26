package com.nst.tales

import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nst.tales.design.image.AnimationIterations
import com.nst.tales.design.image.AnimationType

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size).asImageBitmap()
}

actual fun getFont(): FontFamily = FontFamily(Font(R.font.architun))

@Composable
actual fun AnimatedComponent(
    type: AnimationType,
    modifier: Modifier,
    iterations: AnimationIterations,
    speed: Float,
) {
    val animationRes = when (type) {
        AnimationType.CreateBook -> R.raw.create_book
    }

    var replayOnChangeTrigger by remember(animationRes) { mutableStateOf(false) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))

    val lottieIterations = when (iterations) {
        AnimationIterations.Forever -> LottieConstants.IterateForever
        is AnimationIterations.FixedCount -> iterations.times
    }

    LaunchedEffect(animationRes) {
        // Trigger replay animation when resource changes (magic)
        replayOnChangeTrigger = true
    }

    val animationState = animateLottieCompositionAsState(
        composition = composition,
        iterations = lottieIterations,
        isPlaying = replayOnChangeTrigger,
        speed = speed,
    )

    LottieAnimation(
        composition = composition,
        modifier = modifier,
        progress = { animationState.progress },
    )
}