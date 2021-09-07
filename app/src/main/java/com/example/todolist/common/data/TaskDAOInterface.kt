package com.example.todolist.common.data

import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

interface TaskDAOInterface {

    fun saveTask(task: TaskModel): Boolean
    fun updateTask(task: TaskModel): Boolean
    fun deleteTask(task: TaskModel): Boolean
    fun listTask(): List<TaskModel>
}