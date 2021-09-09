package com.example.todolist.common.data

import android.content.ContentValues
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class TaskDAO(private val dbHelper: DataBaseHelper) {

    var write = dbHelper.writableDatabase
    var read = dbHelper.readableDatabase

    fun saveTask(task: String) {

        write ?: return
        var content = ContentValues()
        content.put(COLUMNS_TASK, task)
        write.insert(TABLE_TASK, null, content)
    }

    fun updateTask(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    fun deleteTask(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    fun listTask(): List<TaskModel> {
        read ?: return mutableListOf()
        val taskList = mutableListOf<TaskModel>()

        val sql = "SELECT * FROM $TABLE_TASK ;"
        var cursor = read.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            var task = TaskModel(
                cursor.getLong(cursor.getColumnIndex(COLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_TASK))
            )
            taskList.add(task)
        }

        return taskList
    }
}