package com.example.todolist.feature.task_list_fragment.di

import com.example.todolist.feature.task_list_fragment.presentation.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val taskListPresentationModule = module {

    viewModel {
        TaskListViewModel(taskDAO = get())
    }
}