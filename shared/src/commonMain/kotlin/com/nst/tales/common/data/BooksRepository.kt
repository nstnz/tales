package com.nst.tales.common.data

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.firebase.FirebaseImpl

internal class BooksRepository(
    private val firebaseImpl: FirebaseImpl
) {

    suspend fun saveBook(bookModel: BookModel) {
        //firebaseImpl.create("")
    }

    suspend fun getBooks(): List<BookModel> {
        return emptyList()
    }
}