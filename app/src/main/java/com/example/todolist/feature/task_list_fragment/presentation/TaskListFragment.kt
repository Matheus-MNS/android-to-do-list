package com.example.todolist.feature.task_list_fragment.presentation

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.todolist.R
import com.example.todolist.common.extensions.setVisible
import com.example.todolist.databinding.FragmentTaskListBinding

private lateinit var binding: FragmentTaskListBinding

class TaskListFragment : Fragment() {
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

        binding.toolbar.arrowBack.setVisible()
        setupTextFont(binding.toolbar.titleTaskList)
    }

    private fun setupTextFont(text: TextView) {
        text.typeface = ResourcesCompat.getFont(requireContext(), R.font.lemon_milk_bold)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat())
    }

}