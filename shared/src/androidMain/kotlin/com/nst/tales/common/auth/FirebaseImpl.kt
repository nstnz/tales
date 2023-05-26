package com.nst.tales.common.auth

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.nst.tales.Android

actual class FirebaseImpl {

    private val auth = Firebase.auth

    init {
        FirebaseApp.initializeApp(Android.context)
    }

    actual suspend fun isSignedIn(): Boolean {
        return auth.currentUser != null
    }

    actual suspend fun anonymousAuth(
        callback: (Boolean) -> Unit
    ) {
        auth.signInAnonymously()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    callback(user != null)
                } else {
                    callback(false)
                }
            }
    }

    actual suspend fun signOut() {
        auth.signOut()
    }
}