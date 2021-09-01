package com.example.todolist.common.extensions

import android.app.Activity
import android.view.WindowManager
import androidx.core.content.ContextCompat

fun Activity.changeStatusBarColor(color: Int) {
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(this.context, color)
    }
}