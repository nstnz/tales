package com.nst.tales.common.domain.model

data class BookModel(
    val id: String,
    val name: String,
    val chapters: List<ChapterModel>,
    val image: String
)
