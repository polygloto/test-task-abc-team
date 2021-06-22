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
import com.mikhailovalx.test_task_abc_team.data.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mutablePlayerListLiveData = MutableLiveData<List<Player>>()
    val playerListLiveData: LiveData<List<Player>> = mutablePlayerListLiveData
    var playerAdapter = PlayersAdapter()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // Let's imagine that this method takes data via api or from a database :)
            val playerList = getPlayers()
            mutablePlayerListLiveData.postValue(playerList)
        }
    }

    private fun getPlayers(): ArrayList<Player> {
        val playersList = ArrayList<Player>()

        val playersNames: Array<String>
        val playersPhotos: Array<String>
        val playerSport: String

        if (SELECTED_GAME == FOOTBALL) {
            playersNames =
                getApplication<Application>().resources.getStringArray(R.array.football_players)
            playersPhotos =
                getApplication<Application>().resources.getStringArray(R.array.football_players_photo)
            playerSport = "Футболист"
        } else {
            playersNames =
                getApplication<Application>().resources.getStringArray(R.array.basketball_players)
            playersPhotos =
                getApplication<Application>().resources.getStringArray(R.array.basketball_players_photo)
            playerSport = "Баскетболист"
        }

        for (n in 0..9) {
            playersList.add(
                Player(
                    name = playersNames[n],
                    sport = playerSport,
                    photoUrl = playersPhotos[n]
                )
            )
        }

        return playersList
    }
}