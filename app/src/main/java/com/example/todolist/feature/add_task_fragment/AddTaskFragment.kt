package com.example.todolist.feature.add_task_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.common.data.TaskDAO
import com.example.todolist.common.extensions.setVisible
import com.example.todolist.databinding.FragmentAddTaskBinding
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var taskModel: TaskModel

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

        with(binding) {
            toolbar.arrowBack.setVisible()
            toolbar.saveTask.setVisible()
            toolbar.arrowBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        val taskName = binding.taskName.text.toString()

        binding.toolbar.saveTask.setOnClickListener {
            taskModel.taks=

        }
    }
}
