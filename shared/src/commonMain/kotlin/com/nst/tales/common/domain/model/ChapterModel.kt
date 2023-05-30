package com.nst.tales.common.domain.model

data class ChapterModel(
    val name: String,
    val text: String,
    val images: List<String>,
    val template: Int,
    val color: Long
)
