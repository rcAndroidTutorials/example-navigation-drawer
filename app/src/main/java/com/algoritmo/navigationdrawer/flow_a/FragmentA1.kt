package com.algoritmo.navigationdrawer.flow_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.algoritmo.navigationdrawer.R
import com.algoritmo.navigationdrawer.databinding.FragmentA1Binding
import com.algoritmo.navigationdrawer.presentation.home.HomeViewModel

class FragmentA1: Fragment() {
    private var _binding: FragmentA1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA1Binding.inflate(inflater, container, false)
        binding.goTo1B.setOnClickListener {
            val options = NavOptions.Builder()
                .setEnterAnim(R.anim.enter)
                .setExitAnim(R.anim.exit)
                .setPopEnterAnim(R.anim.pop_enter)
                .setPopExitAnim(R.anim.pop_exit).build()
            findNavController().navigate(
                FragmentA1Directions.actionFragmentA1ToFragmentA2(),
                options)
        }
        binding.toolbar.setNavigationOnClickListener {
            viewModel.openDrawerSLE.call()
        }
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}