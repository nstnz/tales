package com.nst.tales.common.ui

import androidx.compose.runtime.Composable
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.feature.book.BookScreen

@Composable
fun RootView() {
    AppTheme {
        //App()
        BookScreen(
            BookModel(
                id = "1",
                name = "Booky book",
                image = "",
                chapters = listOf(
                    ChapterModel(
                        name = "1",
                        text = "sfdskjflksdjflk jsdlkfjl sdf",
                        images = emptyList()
                    ),
                    ChapterModel(
                        name = "2",
                        text = "zdkljflsk djflks jdlfjlksd jflk",
                        images = emptyList()
                    ),
                )
            )
        )
    }
}
