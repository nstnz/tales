package com.nst.tales.feature.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.scaffold.GradientScaffold
import kotlinx.coroutines.delay

@Composable
internal fun WelcomeScreen(
    onProceedClick: () -> Unit
) {
    GradientScaffold {
        PrimaryButtonComponent("Proceed", onProceedClick)
    }
}