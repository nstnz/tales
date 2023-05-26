package com.nst.tales.feature.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import com.nst.tales.design.button.PrimaryButtonComponent
import com.nst.tales.design.card.CardComponent
import com.nst.tales.design.image.ImageType
import com.nst.tales.design.image.SimpleIcon
import com.nst.tales.design.input.TextInputComponent
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.InOuterShadow
import com.nst.tales.design.theme.accent2
import com.nst.tales.design.theme.accent3
import com.nst.tales.design.theme.noEffectsClickable
import com.nst.tales.design.theme.textDarkDefault
import com.nst.tales.design.theme.textDarkSecondary
import com.nst.tales.design.theme.textLightDefault
import com.nst.tales.design.topbar.DefaultNavComponent

@Composable
internal fun SurveyScreen(
    state: SurveyScreenState,
    onChangeGender: (Boolean) -> Unit = {},
    onChangeName: (String) -> Unit = {},
    onChangeAge: (String) -> Unit = {},
) {
    GradientScaffold(
        topBar = {
            DefaultNavComponent()
        }
    ) {
        Box(
            Modifier.fillMaxSize().padding(AppTheme.indents.x3),
            contentAlignment = Alignment.Center
        ) {
            CardComponent(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.accent2(),
                    style = AppTheme.typography.body1,
                    text = "Survey kjklj"
                )
                SpacerComponent { x1 }
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.textDarkSecondary(),
                    style = AppTheme.typography.body3,
                    text = "ksjflkjldkfj lskdjflsdkjflks djflskdjfl ksjdlfk jsldfjsdf skjfdkljflksjdfk jsldkfjlsd f",
                )

                Column(
                    modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SpacerComponent { x3 }
                    TextInputComponent(
                        Modifier.fillMaxWidth(),
                        value = TextFieldValue(state.userModel?.name.orEmpty()),
                        placeholder = "Name",
                        label = "sdfdsfsdf",
                        onValueChange = { onChangeName(it.text) }
                    )
                    SpacerComponent { x3 }
                    TextInputComponent(
                        Modifier.fillMaxWidth(),
                        value = TextFieldValue(state.userModel?.age?.toString().orEmpty()),
                        placeholder = "Age",
                        label = "sdfdsfsdf",
                        onValueChange = {}
                    )
                    SpacerComponent { x3 }
                    Text(
                        text = "slfk;lsafkl;s",
                        style = AppTheme.typography.body2,
                        color = AppTheme.colors.textDarkDefault(),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    SpacerComponent { x1 }
                    Row {
                        GenderIcon(
                            isGirl = true,
                            selected = state.userModel?.isGirl == true,
                            onClick = { onChangeGender(true) }
                        )
                        SpacerComponent { x6 }
                        GenderIcon(
                            isGirl = false,
                            selected = state.userModel?.isGirl == false,
                            onClick = { onChangeGender(false) }
                        )
                    }
                    SpacerComponent { x1 }
                    SpacerComponent { x3 }
                }

                Spacer(Modifier.weight(1f))
                PrimaryButtonComponent("Save", {})
            }
        }
    }
}

@Composable
private fun GenderIcon(
    isGirl: Boolean,
    selected: Boolean,
    onClick: () -> Unit
) {
    InOuterShadow(
        modifier = Modifier.alpha(if (selected) 1f else 0.5f),
        cornersRadius = AppTheme.indents.x3,
        addDarkness = true,
        color = AppTheme.colors.accent3(),
    ) {
        Box(
            Modifier
                .noEffectsClickable { onClick() }
                .size(AppTheme.indents.x8_5)
                .background(
                    AppTheme.colors.accent3(),
                    AppTheme.shapes.x3
                )
                .padding(AppTheme.indents.x1)
        ) {
            SimpleIcon(
                type = if (isGirl) ImageType.IcGirl else ImageType.IcBoy,
                modifier = Modifier.align(Alignment.Center)
                    .fillMaxSize(),
                tint = AppTheme.colors.textLightDefault()
            )
        }
    }
}