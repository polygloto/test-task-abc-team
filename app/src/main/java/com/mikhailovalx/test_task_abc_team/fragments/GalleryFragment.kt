package com.mikhailovalx.test_task_abc_team.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mikhailovalx.test_task_abc_team.FOOTBALL
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.SELECTED_GAME
import com.mikhailovalx.test_task_abc_team.adapters.SportPhotoAdapter
import com.mikhailovalx.test_task_abc_team.databinding.FragmentGalleryBinding
import com.mikhailovalx.test_task_abc_team.view_models.GalleryFragmentViewModel
import com.mikhailovalx.test_task_abc_team.view_models.PlayersFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GalleryFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewModel = ViewModelProvider(this).get(GalleryFragmentViewModel::class.java)
        binding.rvSportPhotos.adapter = viewModel.sportsPhotoAdapter
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModel.sportsPhotoListLiveData.observe(this,
            { list ->
                with(viewModel.sportsPhotoAdapter) {
                    photos.clear()
                    photos.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}