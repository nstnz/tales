package com.nst.tales.common.auth

expect class FirebaseImpl() {

    suspend fun anonymousAuth(
        callback: (Boolean) -> Unit
    )

    suspend fun signOut()

    suspend fun isSignedIn(): Boolean
}