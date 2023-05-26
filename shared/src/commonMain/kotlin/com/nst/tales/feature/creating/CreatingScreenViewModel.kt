package com.nst.tales.feature.creating

import com.nst.tales.common.ui.base.CoroutinesViewModel
import com.nst.tales.common.ui.router.Router

internal class CreatingScreenViewModel(
    private val router: Router,
) : CoroutinesViewModel<CreatingScreenState, CreatingScreenIntent, CreatingScreenSingleEvent>() {

    override fun initialState(): CreatingScreenState = CreatingScreenState

    override fun reduce(
        intent: CreatingScreenIntent,
        prevState: CreatingScreenState
    ): CreatingScreenState =
        prevState

    override suspend fun performSideEffects(
        intent: CreatingScreenIntent,
        state: CreatingScreenState
    ): CreatingScreenIntent? = when (intent) {
        CreatingScreenIntent.Load -> {
            null
        }
        CreatingScreenIntent.Proceed -> {
            null
        }
    }
}