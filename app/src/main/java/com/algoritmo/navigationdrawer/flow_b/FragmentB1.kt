package com.algoritmo.navigationdrawer.flow_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.algoritmo.navigationdrawer.R
import com.algoritmo.navigationdrawer.databinding.FragmentB1Binding
import com.algoritmo.navigationdrawer.presentation.home.HomeViewModel

class FragmentB1: Fragment() {
    private var _binding: FragmentB1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentB1Binding.inflate(inflater, container, false)
        binding.goTo2B.setOnClickListener {
            val options = NavOptions.Builder()
                .setEnterAnim(R.anim.enter)
                .setExitAnim(R.anim.exit)
                .setPopEnterAnim(R.anim.pop_enter)
                .setPopExitAnim(R.anim.pop_exit).build()
            findNavController().navigate(
                FragmentB1Directions.actionFragmentB1ToFragmentB2(),
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