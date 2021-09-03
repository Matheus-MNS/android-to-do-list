package com.example.todolist.common.extensions

import android.view.View
import android.widget.TextView

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setGone() {
    this.visibility = View.GONE
}

