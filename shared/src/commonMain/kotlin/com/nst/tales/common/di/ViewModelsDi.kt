package com.nst.tales.common.di

import com.nst.tales.feature.creating.CreatingScreenViewModel
import com.nst.tales.feature.main.MainScreenViewModel
import com.nst.tales.feature.settings.SettingsScreenViewModel
import com.nst.tales.feature.splash.SplashScreenViewModel
import com.nst.tales.feature.survey.SurveyScreenViewModel
import com.nst.tales.feature.welcome.WelcomeScreenViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.bindings.UnboundedScope
import org.kodein.di.instance
import org.kodein.di.multiton
import org.kodein.di.scoped
import org.kodein.di.singleton

internal val splashScope = object : UnboundedScope() {}
internal val mainScope = object : UnboundedScope() {}
internal val welcomeScope = object : UnboundedScope() {}
internal val settingsScope = object : UnboundedScope() {}
internal val creatingScope = object : UnboundedScope() {}
internal val surveyScope = object : UnboundedScope() {}

internal val viewModelsDi = DI.Module(name = "ViewModels") {
    bind<SplashScreenViewModel>() with scoped(splashScope).singleton {
        SplashScreenViewModel(instance(), instance())
    }
    bind<MainScreenViewModel>() with scoped(mainScope).multiton {
        MainScreenViewModel(
            instance(), instance(),
        )
    }
    bind<WelcomeScreenViewModel>() with scoped(welcomeScope).multiton {
        WelcomeScreenViewModel(
            instance(), instance(),
        )
    }
    bind<SettingsScreenViewModel>() with scoped(settingsScope).multiton {
        SettingsScreenViewModel(
            instance(), instance(),
        )
    }
    bind<CreatingScreenViewModel>() with scoped(creatingScope).multiton {
        CreatingScreenViewModel(
            instance(),
        )
    }
    bind<SurveyScreenViewModel>() with scoped(surveyScope).multiton {
        SurveyScreenViewModel(
            instance(),
        )
    }
}