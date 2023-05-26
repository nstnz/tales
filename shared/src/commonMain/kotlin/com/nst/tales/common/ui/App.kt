package com.nst.tales.common.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nst.tales.common.di.SharedDI
import com.nst.tales.common.ui.router.Arg1
import com.nst.tales.common.ui.router.Arg2
import com.nst.tales.common.ui.router.Arg3
import com.nst.tales.common.ui.router.Router
import com.nst.tales.common.ui.router.Routes
import com.nst.tales.feature.creating.CreatingScreenHolder
import com.nst.tales.feature.main.MainScreenHolder
import com.nst.tales.feature.splash.SplashScreenHolder
import com.nst.tales.feature.survey.SurveyScreenHolder
import com.nst.tales.feature.welcome.WelcomeScreenHolder
import moe.tlaster.precompose.navigation.BackStackEntry
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.kodein.di.instance

@Composable
internal fun App() {
    val router: Router by SharedDI.di.instance()
    val navigator = rememberNavigator()
    router.init(navigator)

    Box(Modifier.fillMaxSize()) {
        NavHost(
            navigator = navigator,
            initialRoute = Routes.Splash.name,
            navTransition = NavTransition(
                createTransition = EnterTransition.None,
                resumeTransition = EnterTransition.None,
                destroyTransition = ExitTransition.None,
                pauseTransition = ExitTransition.None,
            )
        ) {
            Routes.values().forEach { route ->
                val content: @Composable (BackStackEntry) -> Unit = {
                    val arg1 = it.queryString?.map?.get(Arg1)?.firstOrNull()
                    val arg2 = it.queryString?.map?.get(Arg2)?.firstOrNull()
                    val arg3 = it.queryString?.map?.get(Arg3)?.firstOrNull()

                    when (route) {
                        Routes.Splash -> SplashScreenHolder()
                        Routes.Main -> MainScreenHolder()
                        Routes.Welcome -> WelcomeScreenHolder()
                        Routes.Creating -> CreatingScreenHolder()
                        Routes.Survey -> SurveyScreenHolder()
                    }
                }

                if (route.floating) {
                    floating(route.name) {
                        content(it)
                    }
                } else {
                    scene(route.name) {
                        content(it)
                    }
                }
            }
        }
    }
}