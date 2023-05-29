package com.nst.tales

import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nst.tales.design.image.AnimationIterations
import com.nst.tales.design.image.AnimationType
import com.nst.tales.design.image.IconType
import com.nst.tales.design.image.ImageType
import java.util.UUID

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size).asImageBitmap()
}

actual fun getFont(): FontFamily = FontFamily(Font(R.font.architun))

actual fun randomUUID() = UUID.randomUUID().toString()

@Composable
actual fun getPainter(
    type: IconType
) = painterResource(
    id = when (type) {
        IconType.IcClose -> R.drawable.ic_close
        IconType.IcBoy -> R.drawable.ic_boy
        IconType.IcGirl -> R.drawable.ic_girl
    }
)

@Composable
actual fun getPainter(
    type: ImageType
) = painterResource(
    id = when (type) {
        ImageType.BgReflection -> R.drawable.bg_reflection
    }
)

@Composable
actual fun AnimatedComponent(
    type: AnimationType,
    modifier: Modifier,
    iterations: AnimationIterations,
    speed: Float,
    isPlaying: Boolean
) {
    val animationRes = when (type) {
        AnimationType.CreateBook -> R.raw.create_book
        AnimationType.MainMenuIcon -> R.raw.main_menu_icon
        AnimationType.SettingsIcon -> R.raw.settings_icon
        AnimationType.BooksIcon -> R.raw.books_icon
    }

    var replayOnChangeTrigger by remember(animationRes) { mutableStateOf(false) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))

    val lottieIterations = when (iterations) {
        AnimationIterations.Forever -> LottieConstants.IterateForever
        is AnimationIterations.FixedCount -> iterations.times
    }

    val animationState = animateLottieCompositionAsState(
        composition = composition,
        iterations = lottieIterations,
        isPlaying = isPlaying,
        speed = speed,
    )

    LottieAnimation(
        composition = composition,
        modifier = modifier,
        progress = { animationState.progress },
    )
}
