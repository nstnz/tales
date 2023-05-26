package com.nst.tales.common.domain.usecase

import com.nst.tales.common.firebase.FirebaseImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class IsSignedInUseCase(
    private val firebase: FirebaseImpl,
    private val dispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke() = withContext(dispatcher) {
        return@withContext firebase.isSignedIn()
    }
}