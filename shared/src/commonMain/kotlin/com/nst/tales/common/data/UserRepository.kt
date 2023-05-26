package com.nst.tales.common.data

import com.nst.tales.common.data.source.UserDataSource
import com.nst.tales.common.domain.model.BookModel

internal class UserRepository(
    private val userDataSource: UserDataSource,
) {

    suspend fun saveBook(bookModel: BookModel) {
        //firebaseImpl.create("")
    }

    fun getUserFlow() = userDataSource.get()
}