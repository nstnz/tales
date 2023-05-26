package com.nst.tales.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.card.CardComponent
import com.nst.tales.design.card.NewBookComponent
import com.nst.tales.design.navbar.NavigationBarComponent
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.ignoreHorizontalParentPadding
import com.nst.tales.design.theme.textLightDefault
import com.nst.tales.design.theme.textLightDisabled
import com.nst.tales.design.theme.textLightSecondary
import com.nst.tales.design.topbar.NavBarComponent
import kotlinx.coroutines.delay
import moe.tlaster.precompose.navigation.NavHost

@Composable
internal fun MainScreen(
    state: MainScreenState
) {
    GradientScaffold {
        Column(Modifier.fillMaxSize().padding(AppTheme.indents.x3)) {
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Hello,",
                    style = AppTheme.typography.body2,
                    color = AppTheme.colors.textLightSecondary(),
                )
                Text(
                    text = state.userName + "!",
                    style = AppTheme.typography.large3,
                    color = AppTheme.colors.textLightDefault(),
                )
            }

            Spacer(Modifier.weight(1f))

            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .ignoreHorizontalParentPadding(AppTheme.indents.x3),
                contentPadding = PaddingValues(AppTheme.indents.x3)
            ) {
                items(1) {
                    NewBookComponent(Modifier.width(296.dp).height(424.dp))
                    SpacerComponent { x2 }
                }
                items(3) {
                    CardComponent(Modifier.width(296.dp).height(424.dp)) {}
                    SpacerComponent { x2 }
                }
            }

            Spacer(Modifier.weight(1f))

            NavigationBarComponent(
                true, false, false,
                {}, {}, {}
            )
        }
    }
}