package com.algoritmo.navigationdrawer.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.algoritmo.navigationdrawer.R
import com.algoritmo.navigationdrawer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val flow1Nav = NavHostFragment.create(R.navigation.flow_a)
        val flow2Nav = NavHostFragment.create(R.navigation.flow_b)
        childFragmentManager.beginTransaction()
            .add(R.id.flContent, flow1Nav, flow1Nav.javaClass.name)
            .add(R.id.flContent, flow2Nav, flow2Nav.javaClass.name)
            .show(flow1Nav)
            .hide(flow2Nav)
            .commitNow()
        binding.navView.findViewById<LinearLayout>(R.id.ll_flow1).setOnClickListener {
            binding.drawerLayout.closeDrawers()
            childFragmentManager.beginTransaction()
                .show(flow1Nav)
                .hide(flow2Nav)
                .commit()
        }
        binding.navView.findViewById<LinearLayout>(R.id.ll_flow2).setOnClickListener {
            binding.drawerLayout.closeDrawers()
            childFragmentManager.beginTransaction()
                .show(flow2Nav)
                .hide(flow1Nav)
                .commit()
        }
        viewModel.openDrawerSLE.observe(viewLifecycleOwner, Observer {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        })
        viewModel.closeDrawerSLE.observe(viewLifecycleOwner, Observer {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        })
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}