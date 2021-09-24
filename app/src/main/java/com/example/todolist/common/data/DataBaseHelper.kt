package com.example.todolist.common.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception
import kotlin.coroutines.coroutineContext

const val VERSION = 1
const val NAME_DB = "DB_TASK"
const val TABLE_TASK = "task"
const val COLUMNS_ID = "id"
const val COLUMNS_TASK = "task"

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, NAME_DB, null, VERSION) {

    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_TASK"
    val CREATE_TABLE = "CREATE TABLE $TABLE_TASK (" +
            "$COLUMNS_ID INTEGER NOT NULL," +
            "$COLUMNS_TASK TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)

        try {
            db!!.execSQL(CREATE_TABLE)
            Log.i("INFO DB", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            Log.i("INFO DB", "Erro ao criar a tabela" + e.message)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }
}