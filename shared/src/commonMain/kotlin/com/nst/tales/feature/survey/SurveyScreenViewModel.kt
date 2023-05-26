package com.nst.tales.feature.survey

import com.nst.tales.common.domain.flow.UserModelFlow
import com.nst.tales.common.domain.usecase.UpdateUserUseCase
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router
import kotlinx.coroutines.flow.lastOrNull

internal class SurveyScreenViewModel(
    private val router: Router,
    private val updateUserUseCase: UpdateUserUseCase,
    private val userModelFlow: UserModelFlow,
) : CoroutinesViewModel<SurveyScreenState, SurveyScreenIntent, SurveyScreenSingleEvent>() {

    init {
        sendIntent(SurveyScreenIntent.Load)
    }

    override fun initialState(): SurveyScreenState = SurveyScreenState(null)

    override fun reduce(
        intent: SurveyScreenIntent,
        prevState: SurveyScreenState
    ): SurveyScreenState = when (intent) {
        is SurveyScreenIntent.Update -> prevState.copy(userModel = intent.userModel)
        is SurveyScreenIntent.UpdateName -> prevState.copy(
            userModel = prevState.userModel?.copy(
                name = intent.name
            )
        )
        is SurveyScreenIntent.UpdateAge -> prevState.copy(
            userModel = prevState.userModel?.copy(
                age = intent.age.toIntOrNull()
            )
        )
        is SurveyScreenIntent.UpdateGender -> prevState.copy(
            userModel = prevState.userModel?.copy(
                isGirl = intent.isGirl
            )
        )
        else -> prevState
    }

    override suspend fun performSideEffects(
        intent: SurveyScreenIntent,
        state: SurveyScreenState
    ): SurveyScreenIntent? = when (intent) {
        SurveyScreenIntent.Load -> {
            sendIntent(SurveyScreenIntent.Update(userModelFlow.flow.lastOrNull()))
            null
        }
        SurveyScreenIntent.Save -> {
            state.userModel?.let {
                updateUserUseCase(state.userModel)
                router.navigateToCreating()
            }
            null
        }
        is SurveyScreenIntent.Update -> null
        is SurveyScreenIntent.UpdateAge -> null
        is SurveyScreenIntent.UpdateGender -> null
        is SurveyScreenIntent.UpdateName -> null
    }
}