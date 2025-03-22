package com.project.memo.di

import com.project.memo.core.domain.repository.PrefsRepository
import com.project.memo.core.data.repository.PrefsRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule: Module = module {
    singleOf(::PrefsRepositoryImpl) bind PrefsRepository::class
}