package com.nst.tales.common.data.source

import com.nst.tales.common.data.mapper.UserMapper
import com.nst.tales.common.domain.model.UserModel
import com.nst.tales.common.firebase.FirebaseImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

internal class UserDataSource(
    private val firebaseImpl: FirebaseImpl,
    private val userMapper: UserMapper
) {

    private val flow: MutableStateFlow<UserModel?> = MutableStateFlow(null)

    init {
        firebaseImpl.setUpdateCallback {
            flow.tryEmit(userMapper.map(it))
        }
    }

    fun get(): Flow<UserModel?> = flow
}