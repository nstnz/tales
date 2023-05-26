package com.nst.tales.common.domain.usecase

import com.nst.tales.common.auth.FirebaseImpl

internal class GetUserUseCase(
    private val firebase: FirebaseImpl
) {

    suspend operator fun invoke(): String? =
        if (firebase.isSignedIn()) "Stewie" else null
}