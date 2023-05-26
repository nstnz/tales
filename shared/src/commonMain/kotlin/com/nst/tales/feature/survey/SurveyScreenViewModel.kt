package com.nst.tales.feature.survey

import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class SurveyScreenViewModel(
    private val router: Router,
) : CoroutinesViewModel<SurveyScreenState, SurveyScreenIntent, SurveyScreenSingleEvent>() {

    override fun initialState(): SurveyScreenState = SurveyScreenState

    override fun reduce(
        intent: SurveyScreenIntent,
        prevState: SurveyScreenState
    ): SurveyScreenState =
        prevState

    override suspend fun performSideEffects(
        intent: SurveyScreenIntent,
        state: SurveyScreenState
    ): SurveyScreenIntent? = when (intent) {
        SurveyScreenIntent.Load -> {
            null
        }
        SurveyScreenIntent.Proceed -> {
            null
        }
    }
}