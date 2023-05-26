package com.nst.tales.common.domain.usecase

import com.nst.tales.common.firebase.FirebaseImpl

internal class GetUserUseCase(
    private val firebase: FirebaseImpl
) {

    suspend operator fun invoke(): String? {
        firebase.createOrUpdate("books", "1", "Hello")

        return if (firebase.isSignedIn()) "Stewie" else null
    }
}