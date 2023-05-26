package com.nst.tales.feature.main

import com.nst.tales.common.domain.flow.UserModelFlow
import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class MainScreenViewModel(
    private val router: Router,
    private val userModelFlow: UserModelFlow,
) : CoroutinesViewModel<MainScreenState, MainScreenIntent, MainScreenSingleEvent>() {

    init {
        sendIntent(MainScreenIntent.Load)
    }

    override fun initialState(): MainScreenState = MainScreenState()

    override fun reduce(
        intent: MainScreenIntent,
        prevState: MainScreenState
    ): MainScreenState = when (intent) {
        is MainScreenIntent.Update -> prevState.copy(user = intent.user)
        else -> prevState
    }

    override suspend fun performSideEffects(
        intent: MainScreenIntent,
        state: MainScreenState
    ): MainScreenIntent? = when (intent) {
        MainScreenIntent.Load -> {
            userModelFlow.flow.collect {
                sendIntent(MainScreenIntent.Update(it))
            }
            null
        }

        is MainScreenIntent.Update -> null
        MainScreenIntent.CreateBook -> {
            router.navigateToCreating()
            null
        }
    }
}