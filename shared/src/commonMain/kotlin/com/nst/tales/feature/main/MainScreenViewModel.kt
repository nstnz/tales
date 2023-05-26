package com.nst.tales.feature.main

import com.nst.tales.common.domain.usecase.GetUserUseCase
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class MainScreenViewModel(
    private val router: Router,
    private val getUserUseCase: GetUserUseCase,
) : CoroutinesViewModel<MainScreenState, MainScreenIntent, MainScreenSingleEvent>() {

    init {
        sendIntent(MainScreenIntent.Load)
    }

    override fun initialState(): MainScreenState = MainScreenState()

    override fun reduce(
        intent: MainScreenIntent,
        prevState: MainScreenState
    ): MainScreenState = when (intent) {
        is MainScreenIntent.Update -> prevState.copy(userName = intent.userName)
        else -> prevState
    }

    override suspend fun performSideEffects(
        intent: MainScreenIntent,
        state: MainScreenState
    ): MainScreenIntent? = when (intent) {
        MainScreenIntent.Load -> {
            val user = getUserUseCase()
            MainScreenIntent.Update(user.orEmpty())
        }
        is MainScreenIntent.Update -> null
    }
}