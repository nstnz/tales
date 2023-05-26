package com.nst.tales.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.di.splashScope
import com.nst.tales.common.ui.base.collectAsStateLifecycleAware
import com.nst.tales.common.ui.router.OnLifecycleEvent
import org.kodein.di.instance

@Composable
internal fun SplashScreenHolder() {
    val viewModel: SplashScreenViewModel by SharedDI.di.instance()
    val viewState by viewModel.viewState.collectAsStateLifecycleAware()

    OnLifecycleEvent(splashScope) { event ->
        when (event) {
            else -> Unit
        }
    }

    SplashScreen(
        onReady = { viewModel.sendIntent(SplashScreenIntent.Load) }
    )
}
