package com.nst.tales.common.firebase

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.nst.tales.Android

actual class FirebaseImpl {

    private val auth = Firebase.auth
    private val database = Firebase.database.reference
    private var callback: ((Any) -> Unit)? = null

    init {
        FirebaseApp.initializeApp(Android.context)
    }

    actual fun setUpdateCallback(callback: (Any) -> Unit) {
        this.callback = callback
    }

    actual suspend fun isSignedIn(): Boolean {
        auth.currentUser?.uid?.let { addUpdatesListener(it) }
        return auth.currentUser != null
    }

    actual suspend fun anonymousAuth(
        callback: (Boolean) -> Unit
    ) {
        auth.signInAnonymously()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.uid?.let { addUpdatesListener(it) }
                    callback(user != null)
                } else {
                    callback(false)
                }
            }
    }

    actual suspend fun signOut() {
        auth.signOut()
    }

    actual suspend fun createOrUpdate(path: String, id: String, model: Any) {
        auth.currentUser?.uid?.let {
            database.child(it).child(path).updateChildren(mapOf(id to model))
        }
    }

    actual suspend fun delete(path: String, id: String) {
        auth.currentUser?.uid?.let {
            database.child(it).child(path).child(id).removeValue()
        }
    }

    private fun addUpdatesListener(key: String) {
        database.child(key).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                callback?.invoke(snapshot.getValue<String>().orEmpty())
            }

            override fun onCancelled(error: DatabaseError) {
                println("onCancelled")
            }
        })
    }
}