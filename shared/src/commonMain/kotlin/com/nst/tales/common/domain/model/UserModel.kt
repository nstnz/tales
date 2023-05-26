package com.nst.tales.common.domain.model

data class UserModel(
    val id: String,
    val name: String,
    val books: List<BookModel>
)
