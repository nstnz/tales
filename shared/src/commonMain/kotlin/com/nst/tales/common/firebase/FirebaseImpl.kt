package com.nst.tales.common.firebase

expect class FirebaseImpl() {

    suspend fun anonymousAuth(
        callback: (Boolean) -> Unit
    )

    suspend fun signOut()

    suspend fun isSignedIn(): Boolean

    suspend fun createOrUpdate(path: String, id: String, model: Any)

    suspend fun delete(path: String, id: String)
}