package com.mikhailovalx.test_task_abc_team.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikhailovalx.test_task_abc_team.FOOTBALL
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.SELECTED_GAME
import com.mikhailovalx.test_task_abc_team.databinding.FragmentRulesBinding


class RulesFragment : Fragment() {

    private var _binding: FragmentRulesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRulesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setRulesText()
    }

    private fun setRulesText() {
        binding.tvRules.text =
            if (SELECTED_GAME == FOOTBALL) getString(R.string.football_rules)
            else getString(R.string.basketball_rules)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}