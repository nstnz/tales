package com.nst.tales.design.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.*
import com.nst.tales.design.theme.AppTheme

@Composable
internal fun NavigationBarComponent(
    mainTabSelected: Boolean = false,
    booksTabSelected: Boolean = false,
    settingsTabSelected: Boolean = false,
    mainTabClick: () -> Unit,
    booksTabClick: () -> Unit,
    settingsTabClick: () -> Unit,
) {
    NavigationBarComponent(
        items = listOf(
            BooksNavigationItem(selected = booksTabSelected, onClick = booksTabClick),
            MainNavigationItem(selected = mainTabSelected, onClick = mainTabClick),
            SettingsNavigationItem(selected = settingsTabSelected, onClick = settingsTabClick),
        )
    )
}

@Composable
private fun NavigationBarComponent(
    items: List<NavigationItem>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Bottom
    ) {
        BottomNavigationItem(items[0])
        Spacer(Modifier.weight(1f))
        BottomNavigationItem(items[1])
        Spacer(Modifier.weight(1f))
        BottomNavigationItem(items[2])
    }
}


@Composable
private fun BottomNavigationItem(
    item: NavigationItem,
) {
    Column(Modifier
        .noEffectsClickable { item.onClick() }) {
        InOuterShadow(
            modifier = Modifier,
            cornersRadius = AppTheme.indents.x3,
            addDarkness = true,
            color = if (item.selected) AppTheme.colors.accent2() else AppTheme.colors.accent3()
        ) {
            Box(
                Modifier
                    .size(if (item.selected) AppTheme.indents.x10 else AppTheme.indents.x8_5)
                    .background(
                        if (item.selected) AppTheme.colors.accent2() else AppTheme.colors.accent3(),
                        AppTheme.shapes.x3
                    )
            ) {
                Icon(
                    item.icon, null,
                    modifier = Modifier.align(Alignment.Center)
                        .size(AppTheme.indents.x3_5),
                    tint = if (item.selected)
                        AppTheme.colors.accent5() else AppTheme.colors.accent5()
                )
            }
        }

        SpacerComponent { x0_5 }

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = item.text,
            color = if (item.selected)
                AppTheme.colors.accent2() else AppTheme.colors.accent3(),
            style = AppTheme.typography.body2
        )
    }
}

internal interface NavigationItem {
    val selected: Boolean
    val onClick: () -> Unit
    val icon: ImageVector
    val text: String
}

private data class MainNavigationItem(
    override val selected: Boolean,
    override val onClick: () -> Unit = {},
    override val icon: ImageVector = Icons.Rounded.AccountBalanceWallet,
    override val text: String = "Home"
) : NavigationItem

private data class BooksNavigationItem(
    override val selected: Boolean,
    override val onClick: () -> Unit = {},
    override val icon: ImageVector = Icons.Rounded.MonetizationOn,
    override val text: String = "Books"
) : NavigationItem

private data class SettingsNavigationItem(
    override val selected: Boolean,
    override val onClick: () -> Unit = {},
    override val icon: ImageVector = Icons.Rounded.Settings,
    override val text: String = "Settings"
) : NavigationItem