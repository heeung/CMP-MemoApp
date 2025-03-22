package com.project.memo.di

import com.project.memo.core.data.local.datastore.DataStore
import org.koin.core.module.Module
import org.koin.dsl.module


val prefModule: Module = module {
    single { DataStore.create() }
}