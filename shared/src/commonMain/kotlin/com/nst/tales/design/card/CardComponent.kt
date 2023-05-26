package com.nst.tales.design.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.InOuterShadow
import com.nst.tales.design.theme.background1

@Composable
internal fun CardComponent(
    modifier: Modifier,
    padding: Dp = AppTheme.indents.x3,
    content: @Composable ColumnScope.() -> Unit
) {
    InOuterShadow(
        modifier,
        cornersRadius = AppTheme.indents.x3
    ) {
        Surface(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            color = AppTheme.colors.background1(),
            shape = AppTheme.shapes.x3
        ) {
            Column(Modifier.fillMaxSize()
                .padding(padding)) {
                content()
            }
        }
    }
}