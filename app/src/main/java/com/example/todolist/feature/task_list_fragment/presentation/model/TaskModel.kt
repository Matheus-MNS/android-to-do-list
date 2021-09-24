package com.example.todolist.feature.task_list_fragment.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TaskModel(
    val id: Int? = null,
    val taskName: String
) : Parcelable


