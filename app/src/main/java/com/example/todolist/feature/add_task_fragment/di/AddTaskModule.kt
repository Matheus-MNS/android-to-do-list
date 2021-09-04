package com.example.todolist.feature.add_task_fragment.di

import org.koin.dsl.module

val addTaskModule = listOf(
    addTaskDataModule,
    addTaskListPresentationModule
)