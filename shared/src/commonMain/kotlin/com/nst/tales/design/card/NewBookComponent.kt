package com.nst.tales.design.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nst.tales.AnimatedComponent
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.image.AnimationIterations
import com.nst.tales.design.image.AnimationType
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.accent2
import com.nst.tales.design.theme.textDarkSecondary

@Composable
internal fun NewBookComponent(
    modifier: Modifier,
) {
    CardComponent(modifier) {
        Box(Modifier.fillMaxWidth().weight(1f)) {
            AnimatedComponent(
                type = AnimationType.CreateBook,
                Modifier.fillMaxSize(),
                iterations = AnimationIterations.Forever
            )
        }
        Column(Modifier.fillMaxWidth()) {
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.accent2(),
                style = AppTheme.typography.body1,
                text = "Create new book!"
            )
            SpacerComponent { x1 }
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.textDarkSecondary(),
                style = AppTheme.typography.body3,
                text = "Join the world of literature and books and journeys and other!"
            )
            SpacerComponent { x3 }
            PrimaryButtonComponent("Create", {})
        }
    }
}