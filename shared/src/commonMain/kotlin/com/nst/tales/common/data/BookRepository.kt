package com.nst.tales.common.data

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.firebase.FirebaseImpl

internal class BookRepository(
    private val firebaseImpl: FirebaseImpl,
) {

    suspend fun saveBook(bookModel: BookModel) {
        firebaseImpl.createOrUpdate("books", bookModel.id, bookModel)
    }
}