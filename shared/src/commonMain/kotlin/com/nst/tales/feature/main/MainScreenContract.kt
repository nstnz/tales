package com.nst.tales.feature.main

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.UserModel
import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal data class MainScreenState(
    val user: UserModel? = null
) : State {

    val books: List<BookModel>
        get() = user?.books ?: emptyList()
}

internal sealed interface MainScreenIntent : Intent {
    object Load : MainScreenIntent
    data class Update(val user: UserModel?) : MainScreenIntent
}

internal sealed class MainScreenSingleEvent : SingleEvent