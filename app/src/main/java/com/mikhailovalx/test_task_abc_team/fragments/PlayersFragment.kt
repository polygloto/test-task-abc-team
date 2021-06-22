package com.mikhailovalx.test_task_abc_team.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mikhailovalx.test_task_abc_team.view_models.PlayersFragmentViewModel
import com.mikhailovalx.test_task_abc_team.databinding.FragmentPlayersBinding

class PlayersFragment : Fragment() {

    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PlayersFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewModel = ViewModelProvider(this).get(PlayersFragmentViewModel::class.java)
        binding.rvPlayers.adapter = viewModel.playerAdapter
        loadPlayers()
    }

    private fun loadPlayers() {
        viewModel.playerListLiveData.observe(this,
            { list ->
                with(viewModel.playerAdapter) {
                    players.clear()
                    players.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}