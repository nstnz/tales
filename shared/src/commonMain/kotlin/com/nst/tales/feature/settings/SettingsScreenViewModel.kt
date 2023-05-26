package com.nst.tales.feature.settings

import com.nst.tales.common.domain.usecase.AnonymousAuthUseCase
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class SettingsScreenViewModel(
    private val router: Router,
    private val authUseCase: AnonymousAuthUseCase
) : CoroutinesViewModel<SettingsScreenState, SettingsScreenIntent, SettingsScreenSingleEvent>() {

    override fun initialState(): SettingsScreenState = SettingsScreenState

    override fun reduce(
        intent: SettingsScreenIntent,
        prevState: SettingsScreenState
    ): SettingsScreenState =
        prevState

    override suspend fun performSideEffects(
        intent: SettingsScreenIntent,
        state: SettingsScreenState
    ): SettingsScreenIntent? = when (intent) {
        SettingsScreenIntent.Load -> {
            null
        }
        SettingsScreenIntent.Proceed -> {
            authUseCase {
                if (it) {
                    router.navigateToMainScreen()
                }
            }
            null
        }
    }
}