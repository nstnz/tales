package com.nst.tales.feature.book

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.design.image.ImageType
import com.nst.tales.design.image.SimpleImage
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.accent5
import com.nst.tales.design.theme.noEffectsClickable
import com.nst.tales.design.theme.textLightDefault
import com.nst.tales.design.theme.transparent

@Composable
internal fun BookScreen(
    bookModel: BookModel,
    coverColor: Color = AppTheme.colors.accent5()
) {
    val count = 2 + bookModel.chapters.size

    val leftPageVisible = remember { mutableStateOf(false) }
    val currentPage = remember { mutableStateOf(0) }
    val rotatedList = mutableListOf<MutableState<Boolean>>()
    repeat(count) {
        rotatedList.add(mutableStateOf(false))
    }

    val goNext = {
        leftPageVisible.value = true
        if (currentPage.value < count - 1) {
            rotatedList[currentPage.value].value = true
            currentPage.value++
        }
    }

    val goPrev = {
        if (currentPage.value >= 0) {
            rotatedList[currentPage.value].value = false
            if (currentPage.value > 0) {
                currentPage.value--
            } else {
                leftPageVisible.value = false
            }
        }
    }

    GradientScaffold {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val h = this.maxHeight
            val neededH = (this.maxWidth - AppTheme.indents.x2 * 2) * 1.75f
            val padding = (h - neededH) / 2

            Surface(
                color = AppTheme.colors.transparent(),
                elevation = AppTheme.indents.x3,
                modifier = Modifier
                    .padding(top = padding)
                    .height(neededH)
                    .width(this.maxWidth - AppTheme.indents.x2 * 2),
                shape = AppTheme.shapes.x2_5
            ) { }

            BoxWithConstraints(
                Modifier
                    .padding(horizontal = AppTheme.indents.x2)
                    .fillMaxSize()
            ) {
                FlipCard(
                    width = this.maxWidth,
                    rotated = rotatedList[count - 1],
                    padding = padding,
                    count = count,
                    page = count - 1,
                    cover = true,
                    onClick = goNext,
                    content = {
                        Cover(coverColor, {})
                    },
                )

                bookModel.chapters.reversed().forEachIndexed { index, chapterModel ->
                    FlipCard(
                        width = this.maxWidth,
                        rotated = rotatedList[count - index - 2],
                        padding = padding,
                        count = count,
                        page = count - index - 2,
                        cover = false,
                        onClick = goNext,
                        content = {
                            Page(chapterModel)
                        },
                    )
                }

                FlipCard(
                    width = this.maxWidth,
                    rotated = rotatedList[0],
                    padding = padding,
                    count = count,
                    page = 0,
                    cover = true,
                    onClick = goNext,
                    content = {
                        Cover(coverColor, {})
                    },
                )
            }

            AnimatedVisibility(
                visible = leftPageVisible.value,
                exit = fadeOut(),
                enter = fadeIn()
            ) {
                Box(
                    Modifier.fillMaxHeight().width(AppTheme.indents.x3)
                        .noEffectsClickable { goPrev() }
                        .padding(vertical = padding - AppTheme.indents.x2)
                        .background(
                            AppTheme.gradients.pageEnd(),
                            RoundedCornerShape(
                                topEndPercent = 100,
                                bottomEndPercent = 100
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun FlipCard(
    width: Dp,
    rotated: MutableState<Boolean>,
    padding: Dp,
    count: Int,
    page: Int,
    content: @Composable () -> Unit,
    cover: Boolean = false,
    onClick: () -> Unit
) {
    val rotation by animateFloatAsState(
        targetValue = if (rotated.value) 270f else 360f,
        animationSpec = tween(500)
    )
    AnimatedVisibility(
        visible = !rotated.value,
        enter = EnterTransition.None,
        exit = fadeOut(tween(250, 350))
    ) {
        Row(
            Modifier.fillMaxHeight()
                .width(width * 2)
                .horizontalScroll(rememberScrollState(), enabled = false),
        ) {
            Box(
                Modifier.fillMaxHeight()
                    .width(width * 2)
                    .offset(width * -1f)
                    .graphicsLayer {
                        rotationY = rotation
                        cameraDistance = 32 * density
                    }
                    .noEffectsClickable {
                        onClick()
                    },
            )
            {
                val paddingH = if (cover) 0.dp else 8.dp
                val paddingW = if (cover) 0.dp else (count - page).dp * 2f + paddingH
                Surface(
                    Modifier
                        .padding(vertical = padding + paddingH)
                        .fillMaxHeight()
                        .width(width - paddingW)
                        .offset(width),
                    color = AppTheme.colors.transparent(),
                    shape = RoundedCornerShape(
                        topEnd = if (!cover) AppTheme.indents.x2 else AppTheme.indents.x2_5,
                        bottomEnd = if (!cover) AppTheme.indents.x2 else AppTheme.indents.x2_5,
                    ),
                    border = BorderStroke(if (cover) 0.dp else 1.dp, Color(0xffd1d1d1))
                ) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
private fun Page(
    chapterModel: ChapterModel
) {
    Box(Modifier.fillMaxSize().background(AppTheme.colors.textLightDefault())) {
        Box(
            Modifier.fillMaxHeight().width(AppTheme.indents.x3)
                .background(AppTheme.gradients.pageStart())
                .align(Alignment.CenterStart)
        )
        Box(Modifier.fillMaxSize().padding(start = AppTheme.indents.x1)) {
            Text(
                text = chapterModel.name,
                style = AppTheme.typography.large1,
                modifier = Modifier,
                color = AppTheme.colors.accent5()
            )
        }
    }
}

@Composable
private fun Cover(
    coverColor: Color,
    coverContent: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = AppTheme.shapes.x0_75,
    ) {
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier.fillMaxSize().background(coverColor)
            )
            coverContent()
            SimpleImage(
                ImageType.BgReflection,
                Modifier.fillMaxSize().alpha(0.3f),
            )
            Box(
                Modifier.fillMaxHeight()
                    .alpha(0.2f)
                    .width(AppTheme.indents.x0_25)
                    .background(Color(0xff555555))
            )
            Box(
                Modifier.fillMaxHeight()
                    .alpha(0.1f)
                    .padding(start = AppTheme.indents.x2)
                    .width(AppTheme.indents.x0_25)
                    .background(Color(0xff555555))
            )
            Box(
                Modifier.fillMaxHeight()
                    .alpha(0.2f)
                    .padding(start = AppTheme.indents.x2_25)
                    .width(AppTheme.indents.x1)
                    .background(AppTheme.gradients.coverStart())
            )
        }
    }
}