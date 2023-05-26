package com.nst.tales.feature.survey

import com.nst.tales.common.domain.model.UserModel
import com.nst.tales.common.ui.base.Intent
import com.nst.tales.common.ui.base.SingleEvent
import com.nst.tales.common.ui.base.State

internal data class SurveyScreenState(
    val userModel: UserModel?
) : State

internal sealed interface SurveyScreenIntent : Intent {
    object Load : SurveyScreenIntent
    data class Update(val userModel: UserModel?) : SurveyScreenIntent
    data class UpdateName(val name: String) : SurveyScreenIntent
    data class UpdateAge(val age: String) : SurveyScreenIntent
    data class UpdateGender(val isGirl: Boolean) : SurveyScreenIntent
    object Save : SurveyScreenIntent
}

internal sealed class SurveyScreenSingleEvent : SingleEvent