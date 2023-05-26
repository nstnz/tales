package com.nst.tales.common.di

import com.nst.tales.common.domain.usecase.AnonymousAuthUseCase
import com.nst.tales.common.domain.usecase.GetUserUseCase
import com.nst.tales.common.firebase.FirebaseImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

internal val coreDi = DI.Module(name = "Core") {
    bind<GetUserUseCase>() with provider {
        GetUserUseCase(instance())
    }
    bind<AnonymousAuthUseCase>() with provider {
        AnonymousAuthUseCase(instance())
    }
    bind<FirebaseImpl>() with singleton {
        FirebaseImpl()
    }
}