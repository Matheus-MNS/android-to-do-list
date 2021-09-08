package com.example.todolist.feature.add_task_fragment.di

import com.example.todolist.feature.add_task_fragment.AddTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addTaskListPresentationModule = module {

    viewModel {
        AddTaskViewModel(taskDAO = get())
    }
}