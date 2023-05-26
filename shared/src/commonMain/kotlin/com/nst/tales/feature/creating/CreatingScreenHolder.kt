package com.nst.tales.feature.creating

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.di.creatingScope
import com.nst.tales.common.ui.base.collectAsStateLifecycleAware
import com.nst.tales.common.ui.router.OnLifecycleEvent
import org.kodein.di.instance

@Composable
internal fun CreatingScreenHolder() {
    val viewModel: CreatingScreenViewModel by SharedDI.di.instance()
    val viewState by viewModel.viewState.collectAsStateLifecycleAware()

    OnLifecycleEvent(creatingScope) { event ->
        when (event) {
            else -> Unit
        }
    }

    CreatingScreen(
        state = viewState,
    )
}
