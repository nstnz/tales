package com.nst.tales.common.domain.flow

import com.nst.tales.common.data.UserRepository

internal class UserModelFlow(
    private val repository: UserRepository
) {

    val flow = repository.getUserFlow()
}