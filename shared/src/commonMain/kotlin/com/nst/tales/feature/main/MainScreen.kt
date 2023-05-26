package com.nst.tales.feature.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nst.tales.design.card.CardComponent
import com.nst.tales.design.card.NewBookComponent
import com.nst.tales.design.navbar.NavigationBarComponent
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.ignoreHorizontalParentPadding
import com.nst.tales.design.theme.textLightDefault
import com.nst.tales.design.theme.textLightSecondary

@OptIn(ExperimentalFoundationApi::class)
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
                    text = state.user?.name + "!",
                    style = AppTheme.typography.large3,
                    color = AppTheme.colors.textLightDefault(),
                )
            }

            Spacer(Modifier.weight(1f))
            val listState = rememberLazyListState()

            LazyRow(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .ignoreHorizontalParentPadding(AppTheme.indents.x3),
                contentPadding = PaddingValues(AppTheme.indents.x3),
                flingBehavior = rememberSnapFlingBehavior(lazyListState = listState),
            ) {
                items(1) {
                    NewBookComponent(Modifier.width(296.dp).height(424.dp))
                    SpacerComponent { x2 }
                }
                items(state.books.size) {
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