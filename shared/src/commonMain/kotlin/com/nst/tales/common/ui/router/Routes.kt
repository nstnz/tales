package com.nst.tales.common.ui.router

internal const val Arg1 = "Arg1"
internal const val Arg2 = "Arg2"
internal const val Arg3 = "Arg3"

internal enum class Routes(val floating: Boolean = false) {
    Splash,
    Main,
    Welcome,
    Creating,
    Survey,
}