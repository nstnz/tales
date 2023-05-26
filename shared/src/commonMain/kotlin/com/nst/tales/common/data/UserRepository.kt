package com.nst.tales.common.data

import com.nst.tales.common.data.source.UserDataSource
import com.nst.tales.common.domain.model.UserModel
import com.nst.tales.common.firebase.FirebaseImpl

internal class UserRepository(
    private val userDataSource: UserDataSource,
    private val firebaseImpl: FirebaseImpl,
) {

    fun getUserFlow() = userDataSource.get()

    suspend fun updateUser(
        userModel: UserModel
    ) {
        firebaseImpl.createOrUpdate("", userModel.id, userModel)
    }
}