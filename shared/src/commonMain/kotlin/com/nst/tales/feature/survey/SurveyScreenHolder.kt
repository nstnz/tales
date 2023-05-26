package com.nst.tales.feature.survey

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.di.surveyScope
import com.nst.tales.common.ui.base.collectAsStateLifecycleAware
import com.nst.tales.common.ui.router.OnLifecycleEvent
import org.kodein.di.instance

@Composable
internal fun SurveyScreenHolder() {
    val viewModel: SurveyScreenViewModel by SharedDI.di.instance()
    val viewState by viewModel.viewState.collectAsStateLifecycleAware()

    OnLifecycleEvent(surveyScope) { event ->
        when (event) {
            else -> Unit
        }
    }

    SurveyScreen(
        state = viewState,
    )
}
