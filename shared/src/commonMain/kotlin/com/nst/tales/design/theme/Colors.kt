package com.nst.tales.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal object Colors

@Composable
@ReadOnlyComposable
internal fun Colors.accent1(): Color = Color(0xFFFFCF25)

@Composable
@ReadOnlyComposable
internal fun Colors.accent2(): Color = Color(0xFFFF7C27)

@Composable
@ReadOnlyComposable
internal fun Colors.accent3(): Color = Color(0xFF5ECDFA)

@Composable
@ReadOnlyComposable
internal fun Colors.accent4(): Color = Color(0xFF2BCB9A)

@Composable
@ReadOnlyComposable
internal fun Colors.accent5(): Color = Color(0xFFEE3449)

@Composable
@ReadOnlyComposable
internal fun Colors.background1(): Color = Color(0xFFFFF5D1)

@Composable
@ReadOnlyComposable
internal fun Colors.background2(): Color = Color(0xFFE7F2FF)

@Composable
@ReadOnlyComposable
internal fun Colors.transparent(): Color = Color(0x00000000)

@Composable
@ReadOnlyComposable
internal fun Colors.textDarkDefault(): Color = Color(0xFF282828)

@Composable
@ReadOnlyComposable
internal fun Colors.textDarkSecondary(): Color = Color(0xCC282828)

@Composable
@ReadOnlyComposable
internal fun Colors.textDarkDisabled(): Color = Color(0x99282828)

@Composable
@ReadOnlyComposable
internal fun Colors.textLightDefault(): Color = Color(0xFFFFFFFF)

@Composable
@ReadOnlyComposable
internal fun Colors.textLightSecondary(): Color = Color(0xCCFFFFFF)

@Composable
@ReadOnlyComposable
internal fun Colors.textLightDisabled(): Color = Color(0x99FFFFFF)

internal fun getColorsForBook(): List<Long> = listOf(
    0xffAED6B8,
    0xffEDFFF1,
    0xffFFF0BB,
    0xffFFE3A6,
    0xffDEDCFF,
    0xffA8A3EC,
    0xffFAEBFF,
    0xffFFBAB4,
    0xffE7F8FF,
    0xFFFFF5D1,
    0xFFE7F2FF
)