package com.nst.tales.common.domain.usecase

import com.nst.tales.common.data.UserRepository
import com.nst.tales.common.domain.model.UserModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class UpdateUserUseCase(
    private val dispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) {

    suspend operator fun invoke(userModel: UserModel) = withContext(dispatcher) {
        repository.updateUser(userModel)
    }
}