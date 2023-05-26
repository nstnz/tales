package com.nst.tales.feature.creating

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal object CreatingScreenState : State

internal sealed interface CreatingScreenIntent : Intent {
    object Load : CreatingScreenIntent
    object Proceed : CreatingScreenIntent
}

internal sealed class CreatingScreenSingleEvent : SingleEvent