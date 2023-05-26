package com.nst.tales.feature.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.di.settingsScope
import com.nst.tales.common.ui.base.collectAsStateLifecycleAware
import com.nst.tales.common.ui.router.OnLifecycleEvent
import org.kodein.di.instance

@Composable
internal fun SettingsScreenHolder() {
    val viewModel: SettingsScreenViewModel by SharedDI.di.instance()
    val viewState by viewModel.viewState.collectAsStateLifecycleAware()

    OnLifecycleEvent(settingsScope) { event ->
        when (event) {
            else -> Unit
        }
    }

    SettingsScreen(
        onProceedClick = { viewModel.sendIntent(SettingsScreenIntent.Proceed) }
    )
}
