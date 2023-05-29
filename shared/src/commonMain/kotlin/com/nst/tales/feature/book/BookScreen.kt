package com.nst.tales.feature.book

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.accent3
import com.nst.tales.design.theme.accent5
import com.nst.tales.design.theme.noEffectsClickable
import com.nst.tales.design.theme.textLightDefault

private const val count = 5

@Composable
internal fun BookScreen() {
    GradientScaffold {
        Box(Modifier.fillMaxSize()) {
            BoxWithConstraints(
                Modifier
                    .padding(horizontal = AppTheme.indents.x3)
                    .fillMaxSize()
            ) {
                FlipCard(this.maxWidth, count, 5)
                FlipCard(this.maxWidth, count, 4)
                FlipCard(this.maxWidth, count, 3)
                FlipCard(this.maxWidth, count, 2)
                FlipCard(this.maxWidth, count, 1)
            }
            Box(
                Modifier.fillMaxHeight().width(AppTheme.indents.x3)
                    .padding(vertical = AppTheme.indents.x5)
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

@Composable
fun FlipCard(
    width: Dp,
    count: Int,
    page: Int
) {
    val rotated = remember { mutableStateOf(false) }

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
                        rotated.value = true
                    },
            )
            {
                Surface(
                    Modifier
                        .padding(vertical = AppTheme.indents.x7)
                        .fillMaxHeight()
                        .width(width - (count - page).dp*2)
                        .offset(width),
                    color = AppTheme.colors.textLightDefault(),
                    shape = RoundedCornerShape(
                        topEnd = AppTheme.indents.x2,
                        bottomEnd = AppTheme.indents.x2,
                    ),
                    border = BorderStroke(1.dp, Color(0xffd1d1d1))
                ) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            Modifier.fillMaxHeight().width(AppTheme.indents.x3)
                                .background(AppTheme.gradients.pageStart())
                                .align(Alignment.CenterStart)
                        )
                        Text(
                            text = "Page $page",
                            style = AppTheme.typography.large1,
                            modifier = Modifier
                        )
                    }

                }
            }
        }
    }
}

@Composable
private fun Page(
    number: Int,
    pageSize: DpSize,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(pageSize)
            .background(AppTheme.colors.accent5())
            .border(
                width = 4.dp,
                color = AppTheme.colors.accent3()
            )
    ) {
        Text(
            text = number.toString(),
            style = AppTheme.typography.large1
        )
    }
}