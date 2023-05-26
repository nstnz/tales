package com.nst.tales.common.domain.usecase

import com.nst.tales.common.auth.FirebaseImpl

internal class AnonymousAuthUseCase(
    private val firebase: FirebaseImpl
) {

    suspend operator fun invoke(callback: (Boolean) -> Unit) {
        firebase.anonymousAuth(callback)
    }
}