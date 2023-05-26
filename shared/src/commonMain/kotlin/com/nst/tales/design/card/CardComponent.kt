package com.nst.tales.design.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.InOuterShadow
import com.nst.tales.design.theme.background1

@Composable
internal fun CardComponent(
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    InOuterShadow(
        modifier,
        cornersRadius = AppTheme.indents.x3
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(AppTheme.colors.background1(), AppTheme.shapes.x3)
                .padding(AppTheme.indents.x3)
        ) {
            content()
        }
    }
}