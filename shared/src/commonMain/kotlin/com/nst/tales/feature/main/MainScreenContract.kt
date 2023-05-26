package com.nst.tales.feature.main

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal data class MainScreenState(
    val userName: String = ""
) : State

internal sealed interface MainScreenIntent : Intent {
    object Load : MainScreenIntent
    data class Update(val userName: String) : MainScreenIntent
}

internal sealed class MainScreenSingleEvent : SingleEvent