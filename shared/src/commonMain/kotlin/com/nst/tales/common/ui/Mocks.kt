package com.nst.tales.common.ui

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.UserModel

internal fun mockUser() = UserModel(
    id = "",
    name = "Nastya",
    age = 10,
    isGirl = true,
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
        mockChapter(0),
        mockChapter(1),
        mockChapter(2),
        mockChapter(3),
        mockChapter(4),
        mockChapter(5),
        mockChapter(6),
    )
)

internal fun mockChapter(index: Int) = ChapterModel(
    name = index.toString(),
    text = "zdkljflsk djflks jdlfjlksd jflk",
    template = index,
    images = listOf(
        "https://thumbs.dreamstime.com/b/group-kids-outdoors-looking-down-camera-square-format-128588960.jpg"
    )
)