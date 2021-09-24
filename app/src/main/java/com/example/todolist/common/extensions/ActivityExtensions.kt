package com.example.todolist.common.extensions

import android.app.Activity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.todolist.feature.task_list_fragment.presentation.DeleteDialogFragment

private const val DELETE = "Delete"

fun Activity.changeStatusBarColor(color: Int) {
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(this.context, color)
    }
}

fun Activity.showDeleteDialog(
    positiveAction: (() -> Unit),
    negativeAction: (() -> Unit)? = null
) {
    val supportFragmentManager = (this as AppCompatActivity).supportFragmentManager
    val deleteDialog = DeleteDialogFragment(
        DeleteDialogFragment.Params(
            positiveAction,
            negativeAction
        )
    )

    deleteDialog.show(supportFragmentManager, DELETE)
}