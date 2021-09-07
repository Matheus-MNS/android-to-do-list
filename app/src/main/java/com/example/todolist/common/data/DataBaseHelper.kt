package com.example.todolist.common.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception
import kotlin.coroutines.coroutineContext

private const val VERSION = 1
private const val NAME_DB = "DB_TASK"
private const val TABLE_TASK = "task"

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, NAME_DB, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableTask =
            ("CREATE TABLE IF NOT EXISTS $TABLE_TASK " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                    " name TEXT NOT NULL )")

        try {
            db!!.execSQL(createTableTask)
            Log.i("INFO DB", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            Log.i("INFO DB", "Erro ao criar a tabela" + e.message)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}