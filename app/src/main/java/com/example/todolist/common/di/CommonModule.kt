package com.example.todolist.common.di

import com.example.todolist.common.data.DataBaseHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {

    single {
        DataBaseHelper(androidApplication())
    }
}
