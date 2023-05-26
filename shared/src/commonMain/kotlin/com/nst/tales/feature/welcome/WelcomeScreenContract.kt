package com.nst.tales.feature.welcome

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal object WelcomeScreenState : State

internal sealed interface WelcomeScreenIntent : Intent {
    object Load : WelcomeScreenIntent
    object Proceed : WelcomeScreenIntent
}

internal sealed class WelcomeScreenSingleEvent : SingleEvent