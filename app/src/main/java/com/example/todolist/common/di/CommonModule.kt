package com.example.todolist.common.di

import com.example.todolist.common.data.DataBaseHelper
import com.example.todolist.common.data.TaskDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {

    single {
        DataBaseHelper(androidApplication())
    }

    factory {
        TaskDAO(dbHelper = get())
    }
}
