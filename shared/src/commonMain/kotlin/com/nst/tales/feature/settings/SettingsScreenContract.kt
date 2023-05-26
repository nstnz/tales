package com.nst.tales.feature.settings

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal object SettingsScreenState : State

internal sealed interface SettingsScreenIntent : Intent {
    object Load : SettingsScreenIntent
    object Proceed : SettingsScreenIntent
}

internal sealed class SettingsScreenSingleEvent : SingleEvent