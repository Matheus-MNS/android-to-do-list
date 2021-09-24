package com.example.todolist.common.extensions


import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment


fun DialogFragment.setWindowFeatures() {
    dialog?.apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.decorView?.setBackgroundResource(android.R.color.transparent)
        window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}