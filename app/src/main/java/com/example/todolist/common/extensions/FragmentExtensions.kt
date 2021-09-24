package com.example.todolist.common.extensions

import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(color: Int) {
    activity?.changeStatusBarColor(color)
}

fun Fragment.showDeleteDialog(
    positiveAction: (() -> Unit),
    negativeAction: (() -> Unit)? = null
) {
    activity?.showDeleteDialog(positiveAction, negativeAction)
}