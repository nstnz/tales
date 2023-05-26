package com.nst.tales.design.snackbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.background1
import com.nst.tales.design.theme.textLightDefault

@Composable
internal fun SnackbarComponent(
    title: String,
    description: String? = null,
    isError: Boolean,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = AppTheme.indents.x3,
                vertical = AppTheme.indents.x1_5,
            )
    ) {
        Surface(
            modifier = Modifier
                .align(Alignment.TopCenter),
            shape = AppTheme.shapes.x2,
            color = if (isError) {
                AppTheme.colors.background1()
            } else {
                AppTheme.colors.background1()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.indents.x2),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = title,
                    style = AppTheme.typography.body2,
                    color = AppTheme.colors.textLightDefault()
                )
                description?.let {
                    SpacerComponent { x0_75 }
                    Text(
                        text = it,
                        style = AppTheme.typography.body2,
                        color = AppTheme.colors.textLightDefault(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}