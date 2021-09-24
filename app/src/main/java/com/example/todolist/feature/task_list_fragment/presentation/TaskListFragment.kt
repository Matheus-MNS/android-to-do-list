package com.example.todolist.feature.task_list_fragment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todolist.common.extensions.setVisible
import com.example.todolist.common.extensions.showDeleteDialog
import com.example.todolist.databinding.FragmentTaskListBinding
import com.example.todolist.feature.task_list_fragment.presentation.adapter.TaskAdapter
import com.example.todolist.feature.task_list_fragment.presentation.model.TaskModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private val viewModel: TaskListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTaskList()
        handleObserver()

        with(binding) {
            toolbar.titleTaskList.setVisible()
            fab.setOnClickListener {
                navigateToAddTask()
            }
        }
    }

    private fun handleObserver() {
        viewModel.taskList.observe(
            viewLifecycleOwner, Observer(
                ::handleRecyclerView
            )
        )
    }

    private fun handleRecyclerView(list: List<TaskModel>) {
        val taskAdapter = TaskAdapter(list)
        binding.taskListRecyclerView.adapter = taskAdapter

        with(taskAdapter) {
            onItemLongClick = {
                showDeleteDialog(
                    positiveAction = {
                        it?.let { id -> viewModel.deleteTask(id) }
                        viewModel.getTaskList()
                    }
                )
            }

            onItemClick = {
                navigateToAddTask(TaskModel(it.first, it.second))
            }
        }
    }

    private fun navigateToAddTask(taskModel: TaskModel? = null) {
        findNavController().navigate(
            TaskListFragmentDirections.actionTaskListFragmentToAddTaskFragment(taskModel)
        )
    }
}