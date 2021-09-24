package com.example.todolist.feature.add_task_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.todolist.common.extensions.setVisible
import com.example.todolist.databinding.FragmentAddTaskBinding
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private val viewModel: AddTaskViewModel by viewModel()
    val args: AddTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        binding.taskName.setText(args.task?.taskName)
    }

    private fun setupToolbar() {
        with(binding) {
            toolbar.arrowBack.setVisible()
            toolbar.arrowBack.setOnClickListener {
                findNavController().popBackStack()
            }
            toolbar.saveTask.setVisible()

            validateAction()
        }
    }

    private fun validateAction() {
        if (args.task != null) {
            updateTask()
        } else {
            saveTask()
        }
    }

    private fun updateTask() {
        val id = args.task?.id
        with(binding) {
            toolbar.saveTask.setOnClickListener {
                viewModel.updateTask(TaskModel(id, taskName.text.toString()))
                findNavController().popBackStack()
            }
        }

    }

    private fun saveTask() {
        with(binding) {
            toolbar.saveTask.setOnClickListener {
                viewModel.saveTask(taskName.text.toString())
                findNavController().popBackStack()
            }
        }
    }


}
