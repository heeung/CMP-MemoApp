package com.project.memo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            networkModule,
            repositoryModule,
            useCaseModule,
            serviceModule,
            prefModule,
            platformModule,
            sharedModule
        )
    }
}