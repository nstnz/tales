package com.nst.tales.common.domain.model

data class ChapterPartModel(
    val text: String,
    val image: String,
    val template: PageTemplate,
    val color: Long,
    val name: String?,
)