package com.example.todolist.common.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel
import java.lang.Exception

class TaskDAO(private val dbHelper: DataBaseHelper) {

    private var write = dbHelper.writableDatabase
    private var read = dbHelper.readableDatabase
    var content = ContentValues()
    fun saveTask(task: String) {

        write ?: return

        content.put(COLUMNS_TASK, task)
        write.insert(TABLE_TASK, null, content)
    }

    fun updateTask(task: TaskModel) {

        write ?: return
        val sql = "UPDATE $TABLE_TASK SET $COLUMNS_TASK = ? WHERE $COLUMNS_ID = ?"
        val arg = arrayOf(task.taskName, task.id)
        write.execSQL(sql, arg)
    }

    fun deleteTask(id: Int) {
        write ?: return
        val sql = "DELETE FROM $TABLE_TASK WHERE $COLUMNS_ID = ?"
        val arg = arrayOf("$id")
        write.execSQL(sql, arg)
    }


    @SuppressLint("Range")
    fun listTask(): List<TaskModel> {
        read ?: return mutableListOf()
        val taskList = mutableListOf<TaskModel>()

        val sql = "SELECT * FROM $TABLE_TASK ;"
        var cursor = read.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            var task = TaskModel(
                cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_TASK))
            )
            taskList.add(task)
        }

        return taskList
    }
}