package com.nst.tales.feature.splash

import com.nst.tales.common.domain.usecase.AnonymousAuthUseCase
import com.nst.tales.common.domain.usecase.GetUserUseCase
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class SplashScreenViewModel(
    private val router: Router,
    private val getUserUseCase: GetUserUseCase,
) : CoroutinesViewModel<SplashScreenState, SplashScreenIntent, SplashScreenSingleEvent>() {

    override fun initialState(): SplashScreenState = SplashScreenState

    override fun reduce(
        intent: SplashScreenIntent,
        prevState: SplashScreenState
    ): SplashScreenState =
        prevState

    override suspend fun performSideEffects(
        intent: SplashScreenIntent,
        state: SplashScreenState
    ): SplashScreenIntent? = when (intent) {
        SplashScreenIntent.Load -> {
            if (getUserUseCase() == null) {
                //first launch
                router.navigateToWelcomeScreen()
            } else {
                router.navigateToMainScreen()
            }
            null
        }
    }
}