package com.mikhailovalx.test_task_abc_team.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.mikhailovalx.test_task_abc_team.BASKETBALL
import com.mikhailovalx.test_task_abc_team.FOOTBALL
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.SELECTED_GAME
import com.mikhailovalx.test_task_abc_team.activities.MainActivity
import com.mikhailovalx.test_task_abc_team.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {

        // using a variable SELECTED_GAME is bad practice.
        // Find a way to pass arguments to each fragments from the bottom navigation menu.

        binding.btnFootball.setOnClickListener {
            SELECTED_GAME = FOOTBALL
            getMainActivity(activity)?.navController?.navigate(R.id.rulesFragment)
        }

        binding.btnBasketball.setOnClickListener {
            SELECTED_GAME = BASKETBALL
            getMainActivity(activity)?.navController?.navigate(R.id.rulesFragment)
        }

    }

    private fun getMainActivity(activity: FragmentActivity?): MainActivity? =
        if (activity is MainActivity) activity else null

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

