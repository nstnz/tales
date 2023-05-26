package com.nst.tales.previews

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.UserModel

internal fun mockUser() = UserModel(
    id = "",
    name = "Nastya",
    books = listOf(
        mockBook(),
        mockBook(),
        mockBook(),
        mockBook(),
    )
)

internal fun mockBook() = BookModel(
    id = "1",
    name = "Booky book",
    image = "",
    chapters = listOf(
        ChapterModel(
            name = "1",
            text = "sfdskjflksdjflk jsdlkfjl sdf",
            images = emptyList()
        ),ChapterModel(
            name = "2",
            text = "zdkljflsk djflks jdlfjlksd jflk",
            images = emptyList()
        ),
    )
)