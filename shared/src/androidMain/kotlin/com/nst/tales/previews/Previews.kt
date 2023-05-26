package com.nst.tales.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.feature.main.MainScreen
import com.nst.tales.feature.main.MainScreenState
import com.nst.tales.feature.splash.SplashScreen

@Preview
@Composable
private fun SplashPreview() {
    AppTheme {
        SplashScreen()
    }
}
@Preview
@Composable
private fun MainPreview() {
    AppTheme {
        MainScreen(MainScreenState(mockUser()), {})
    }
}