package com.example.todolist.feature.task_list_fragment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todolist.common.extensions.setWindowFeatures
import com.example.todolist.databinding.DialogDeleteBinding
import com.example.todolist.feature.task_list_fragment.presentation.adapter.TaskAdapter
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DeleteDialogFragment(private val params: Params) : DialogFragment() {

    private lateinit var binding: DialogDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogDeleteBinding.inflate(inflater, container, false)
        setWindowFeatures()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleButtonClick()
    }

    private fun handleButtonClick() {
        with(binding) {

            positveButton.setOnClickListener {
                params.positiveAction.invoke()
                dismiss()
            }

            negativeButton.setOnClickListener {
                params.negativeAction?.invoke()
                dismiss()
            }
        }
    }

    data class Params(
        var positiveAction: (() -> Unit),
        var negativeAction: (() -> Unit)?
    )


}