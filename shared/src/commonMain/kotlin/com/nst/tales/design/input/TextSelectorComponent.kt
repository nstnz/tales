package com.nst.tales.design.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.nst.tales.design.theme.*
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.noEffectsClickable

@Composable
internal fun TextSelectorComponent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
    label: String,
    hint: String = "",
    onClick: (String) -> Unit = {}
) {
    Box(modifier.noEffectsClickable {
        onClick(text)
    }) {
        TextInputComponent(
            Modifier.fillMaxWidth(),
            enabled = false,
            value = TextFieldValue(text),
            placeholder = "",
            hint = hint,
            label = label,
            onValueChange = {},
            trailingIcon = {
                IconButton(
                    modifier = Modifier.padding(end = AppTheme.indents.x0_5),
                    onClick = {}
                ) {
                    Icon(
                        Icons.Rounded.NavigateNext,
                        null,
                        tint = AppTheme.colors.accent1()
                    )
                }
            }
        )
    }
}