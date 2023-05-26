package com.nst.tales.feature.welcome

import com.nst.tales.common.domain.usecase.AnonymousAuthUseCase
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class WelcomeScreenViewModel(
    private val router: Router,
    private val authUseCase: AnonymousAuthUseCase
) : CoroutinesViewModel<WelcomeScreenState, WelcomeScreenIntent, WelcomeScreenSingleEvent>() {

    override fun initialState(): WelcomeScreenState = WelcomeScreenState

    override fun reduce(
        intent: WelcomeScreenIntent,
        prevState: WelcomeScreenState
    ): WelcomeScreenState =
        prevState

    override suspend fun performSideEffects(
        intent: WelcomeScreenIntent,
        state: WelcomeScreenState
    ): WelcomeScreenIntent? = when (intent) {
        WelcomeScreenIntent.Load -> {
            null
        }
        WelcomeScreenIntent.Proceed -> {
            authUseCase {
                if (it) {
                    router.navigateToMainScreen()
                }
            }
            null
        }
    }
}