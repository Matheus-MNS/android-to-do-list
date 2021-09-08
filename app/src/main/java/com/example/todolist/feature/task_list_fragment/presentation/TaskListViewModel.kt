package com.example.todolist.feature.task_list_fragment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.common.data.TaskDAO
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class TaskListViewModel(private val taskDAO: TaskDAO) : ViewModel() {


    val taskList: MutableLiveData<List<TaskModel>> by lazy {
        MutableLiveData<List<TaskModel>>()
    }

    fun getTaskList() {

        taskList.value = taskDAO.listTask()
    }
}