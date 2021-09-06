package com.example.todolist.base_app

import android.app.Application
import com.example.todolist.common.di.commonModule
import com.example.todolist.feature.add_task_fragment.di.addTaskModule
import com.example.todolist.feature.task_list_fragment.di.taskListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(

                taskListModule +
                        addTaskModule +
                        commonModule
            ).androidContext(applicationContext)
        }
    }
}