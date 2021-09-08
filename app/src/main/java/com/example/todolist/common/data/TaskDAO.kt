package com.example.todolist.common.data

import android.annotation.SuppressLint
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class TaskDAO(private val dbHelper: DataBaseHelper) {

    var write = dbHelper.writableDatabase
    var read = dbHelper.readableDatabase

    fun saveTask(task: String): Boolean {


        val contentValuesOf = contentValuesOf(Pair("task", task))

        try {
            write.insert(dbHelper.databaseName, null, contentValuesOf)
            Log.i("INFO", "Tarefa salva com sucesso")
        } catch (e: Exception) {
            Log.e("INFO", "Erro ao salvar tarefa" + e.message)
            return false
        }

        return true
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
        read.close()
        return taskList
    }
}