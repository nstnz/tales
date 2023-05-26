package com.nst.tales.common.di

import com.nst.tales.common.data.BookRepository
import com.nst.tales.common.data.UserRepository
import com.nst.tales.common.data.mapper.UserMapper
import com.nst.tales.common.data.source.UserDataSource
import com.nst.tales.common.domain.flow.UserModelFlow
import com.nst.tales.common.domain.usecase.AnonymousAuthUseCase
import com.nst.tales.common.domain.usecase.CreateBookUseCase
import com.nst.tales.common.domain.usecase.IsSignedInUseCase
import com.nst.tales.common.domain.usecase.UpdateUserUseCase
import com.nst.tales.common.firebase.FirebaseImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

internal val coreDi = DI.Module(name = "Core") {
    bind<UserModelFlow>() with singleton {
        UserModelFlow(instance())
    }
    bind<AnonymousAuthUseCase>() with provider {
        AnonymousAuthUseCase(instance(), instance())
    }
    bind<FirebaseImpl>() with singleton {
        FirebaseImpl()
    }
    bind<UserDataSource>() with singleton {
        UserDataSource(instance(), instance())
    }
    bind<UserMapper>() with provider {
        UserMapper()
    }
    bind<UserRepository>() with singleton {
        UserRepository(instance(), instance())
    }
    bind<BookRepository>() with singleton {
        BookRepository(instance())
    }
    bind<IsSignedInUseCase>() with provider {
        IsSignedInUseCase(instance(), instance())
    }
    bind<CreateBookUseCase>() with provider {
        CreateBookUseCase(instance(), instance())
    }
    bind<UpdateUserUseCase>() with provider {
        UpdateUserUseCase(instance(), instance())
    }
}