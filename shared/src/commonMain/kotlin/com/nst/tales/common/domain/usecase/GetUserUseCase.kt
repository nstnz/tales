package com.nst.tales.common.domain.usecase

import com.nst.tales.common.data.source.UserDataSource
import com.nst.tales.common.firebase.FirebaseImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class GetUserUseCase(
    private val firebase: FirebaseImpl,
    private val userDataSource: UserDataSource,
    private val dispatcher: CoroutineDispatcher,
    private val scope: CoroutineScope,
) {

    suspend operator fun invoke(): String? = withContext(dispatcher) {
        scope.launch {
            userDataSource.getFlow().collect {
                println("-------- OLOLO" + it)
            }
        }

        firebase.createOrUpdate("books", "1", "Hello")

        return@withContext if (firebase.isSignedIn()) "Stewie" else null
    }
}