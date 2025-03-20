package com.project.memo.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import com.project.memo.home.presentation.HomeViewModel
import com.project.memo.settings.presentation.SettingViewModel

expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::SettingViewModel)
}