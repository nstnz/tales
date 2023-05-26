package com.nst.tales.feature.splash

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal object SplashScreenState : State

internal sealed interface SplashScreenIntent : Intent {
    object Load : SplashScreenIntent
}

internal sealed class SplashScreenSingleEvent : SingleEvent