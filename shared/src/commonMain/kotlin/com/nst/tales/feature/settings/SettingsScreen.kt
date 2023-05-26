package com.nst.tales.feature.settings

import androidx.compose.runtime.Composable
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.scaffold.GradientScaffold

@Composable
internal fun SettingsScreen(
    onProceedClick: () -> Unit
) {
    GradientScaffold {
        PrimaryButtonComponent("Proceed", onProceedClick)
    }
}