package com.nst.tales.common.domain.usecase

import com.nst.tales.common.firebase.FirebaseImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class AnonymousAuthUseCase(
    private val firebase: FirebaseImpl,
    private val dispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(callback: (Boolean) -> Unit) {
        withContext(dispatcher) {
            firebase.anonymousAuth(callback)
        }
    }
}