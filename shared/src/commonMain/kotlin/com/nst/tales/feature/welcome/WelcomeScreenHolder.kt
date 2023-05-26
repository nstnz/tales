package com.nst.tales.feature.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.di.welcomeScope
import com.nst.tales.common.ui.base.collectAsStateLifecycleAware
import com.nst.tales.common.ui.router.OnLifecycleEvent
import org.kodein.di.instance

@Composable
internal fun WelcomeScreenHolder() {
    val viewModel: WelcomeScreenViewModel by SharedDI.di.instance()
    val viewState by viewModel.viewState.collectAsStateLifecycleAware()

    OnLifecycleEvent(welcomeScope) { event ->
        when (event) {
            else -> Unit
        }
    }

    WelcomeScreen(
        onProceedClick = { viewModel.sendIntent(WelcomeScreenIntent.Proceed) }
    )
}
