package com.mikhailovalx.test_task_abc_team.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mikhailovalx.test_task_abc_team.FOOTBALL
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.SELECTED_GAME
import com.mikhailovalx.test_task_abc_team.adapters.PlayersAdapter
import com.mikhailovalx.test_task_abc_team.adapters.SportPhotoAdapter
import com.mikhailovalx.test_task_abc_team.data.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GalleryFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mutableSportsPhotoListLiveData = MutableLiveData<List<String>>()
    val sportsPhotoListLiveData: LiveData<List<String>> = mutableSportsPhotoListLiveData
    var sportsPhotoAdapter = SportPhotoAdapter()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // Let's imagine that this method takes data via api or from a database :)
            val sportPhotosList = getSportPhotos()
            mutableSportsPhotoListLiveData.postValue(sportPhotosList)
        }
    }

    private fun getSportPhotos(): ArrayList<String> {
        val photos =
            if (SELECTED_GAME == FOOTBALL) getApplication<Application>().resources.getStringArray(R.array.football_photos)
            else getApplication<Application>().resources.getStringArray(R.array.basketball_photos)

        val arrayListPhotos = ArrayList<String>()
        arrayListPhotos.addAll(photos)

        return arrayListPhotos
    }
}