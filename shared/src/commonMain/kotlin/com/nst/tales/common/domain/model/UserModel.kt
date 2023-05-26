package com.nst.tales.common.domain.model

data class UserModel(
    val id: String,
    val name: String,
    val books: List<BookModel>,
    val age: Int?,
    val isGirl: Boolean?
)
