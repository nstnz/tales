package com.nst.tales.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.scaffold.GradientScaffold
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen(
    onReady: () -> Unit = {}
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
        delay(1000)
        onReady()
    }

    GradientScaffold {
    }
}