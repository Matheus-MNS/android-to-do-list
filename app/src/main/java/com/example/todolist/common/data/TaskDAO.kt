package com.example.todolist.common.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class TaskDAO(context: Context) : TaskDAOInterface {

    private lateinit var write: SQLiteDatabase
    private lateinit var read: SQLiteDatabase

    private lateinit var db: DataBaseHelper


    override fun saveTask(task: TaskModel): Boolean {
        write = db.writableDatabase
        val contentValuesOf = contentValuesOf(Pair("name", "teste"))

        try {
            write.insert(db.databaseName, null, contentValuesOf)
            Log.i("INFO", "Tarefa salva com sucesso")
        } catch (e: Exception) {
            Log.e("INFO", "Erro ao salvar tarefa" + e.message)
            return false
        }

        return true
    }

    override fun updateTask(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun listTask(): List<TaskModel> {
        TODO("Not yet implemented")
    }
}