package com.nst.tales.android

import android.app.Application
import com.nst.tales.Android
import com.nst.tales.common.di.SharedDI

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Android.context = this
        Thread.setDefaultUncaughtExceptionHandler(TopExceptionHandler())
        SharedDI.initializeWithParams()
    }
}

private class TopExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread, e: Throwable) {
        println(e.toString())
    }
}