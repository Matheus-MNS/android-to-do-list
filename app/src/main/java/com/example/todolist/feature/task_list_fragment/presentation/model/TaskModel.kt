package com.example.todolist.feature.task_list_fragment.presentation.model

import com.google.gson.annotations.SerializedName


data class TaskModel(
    @SerializedName("id")
    var taskId: Int,
    @SerializedName("task")
    var taks: String
)
