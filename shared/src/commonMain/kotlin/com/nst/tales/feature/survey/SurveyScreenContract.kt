package com.nst.tales.feature.survey

import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal object SurveyScreenState : State

internal sealed interface SurveyScreenIntent : Intent {
    object Load : SurveyScreenIntent
    object Proceed : SurveyScreenIntent
}

internal sealed class SurveyScreenSingleEvent : SingleEvent