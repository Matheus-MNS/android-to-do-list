package com.example.todolist.feature.add_task_fragment

import androidx.lifecycle.ViewModel
import com.example.todolist.common.data.TaskDAO
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class AddTaskViewModel(private val taskDAO: TaskDAO) : ViewModel() {

    fun saveTask(task: String) =
        taskDAO.saveTask(task)

    fun updateTask(task: TaskModel) =
        taskDAO.updateTask(task)
}