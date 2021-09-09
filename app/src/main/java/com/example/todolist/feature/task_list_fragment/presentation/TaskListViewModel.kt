package com.example.todolist.feature.task_list_fragment.presentation

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.common.data.TaskDAO
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel
import java.lang.Exception

class TaskListViewModel(private val taskDAO: TaskDAO) : ViewModel() {


    val taskList: MutableLiveData<List<TaskModel>> by lazy {
        MutableLiveData<List<TaskModel>>()
    }

    init {
        getTaskList()
    }

    fun getTaskList() {

        taskList.value = taskDAO.listTask()
        try {
            taskList.value = taskDAO.listTask() ?: mutableListOf()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}