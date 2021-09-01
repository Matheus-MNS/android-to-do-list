package com.example.todolist.base_app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.common.extensions.changeStatusBarColor
import com.example.todolist.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupTextFont(binding.title)

//        Handler(Looper.getMainLooper()).postDelayed(
//            {
//                findNavController().navigate(
//                    SplashFragmentDirections.actionSplashFragmentToUserPostFragment()
//                )
//            }, 1000
//        )

    }

    private fun setupView() {
        changeStatusBarColor(R.color.red_light)
    }

    private fun setupTextFont(text: TextView) {
        text.typeface = ResourcesCompat.getFont(requireContext(), R.font.lemon_milk_bold)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50.toFloat())
    }


}