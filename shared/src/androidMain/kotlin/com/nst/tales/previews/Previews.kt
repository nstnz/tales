package com.nst.tales.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.feature.book.BookScreen
import com.nst.tales.feature.creating.CreatingScreen
import com.nst.tales.feature.main.MainScreen
import com.nst.tales.feature.main.MainScreenState
import com.nst.tales.feature.splash.SplashScreen
import com.nst.tales.feature.survey.SurveyScreen
import com.nst.tales.feature.survey.SurveyScreenState

@Preview
@Composable
private fun SplashScreenPreview() {
    AppTheme {
        SplashScreen()
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreen(MainScreenState(mockUser()), {})
    }
}

@Preview
@Composable
private fun SurveyScreenPreview() {
    AppTheme {
        SurveyScreen(SurveyScreenState(null))
    }
}

@Preview
@Composable
private fun CreatingScreenPreview() {
    AppTheme {
        CreatingScreen()
    }
}

@Preview
@Composable
private fun BookScreenPreview() {
    AppTheme {
        BookScreen(mockBook())
    }
}