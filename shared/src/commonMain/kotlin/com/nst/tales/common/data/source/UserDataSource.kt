package com.nst.tales.common.data.source

import com.nst.tales.common.firebase.FirebaseImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class UserDataSource(
    private val firebaseImpl: FirebaseImpl
) {

    private val flow: MutableSharedFlow<String> = MutableSharedFlow()

    init {
        firebaseImpl.setUpdateCallback {
            flow.tryEmit(it.toString())
        }
    }

    fun getFlow() = flow as Flow<String>
}