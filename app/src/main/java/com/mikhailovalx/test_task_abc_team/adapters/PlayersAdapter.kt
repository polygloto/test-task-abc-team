package com.mikhailovalx.test_task_abc_team.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.data.Player
import com.squareup.picasso.Picasso

class PlayersAdapter(val players: MutableList<Player> = mutableListOf()) :
    RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        )
    }

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(player: Player) {
            Picasso.get()
                .load(player.photoUrl)
                .into(itemView.findViewById<ImageView>(R.id.img_player_photo))

            itemView.findViewById<TextView>(R.id.tv_player_name).text = player.name
            itemView.findViewById<TextView>(R.id.tv_player_game).text = player.sport
        }
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int = players.size
}