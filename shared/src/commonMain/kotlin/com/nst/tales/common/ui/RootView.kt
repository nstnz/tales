package com.nst.tales.common.ui

import androidx.compose.runtime.Composable
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.feature.book.BookScreen

@Composable
fun RootView() {
    AppTheme {
        //App()
        BookScreen(mockBook())
    }
}
