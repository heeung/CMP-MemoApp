package com.project.memo.di

import com.project.memo.core.domain.usecase.GetPrefsDarkTheme
import com.project.memo.core.domain.usecase.SetPrefsDarkTheme
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single { GetPrefsDarkTheme(get()) }
    single { SetPrefsDarkTheme(get()) }
}