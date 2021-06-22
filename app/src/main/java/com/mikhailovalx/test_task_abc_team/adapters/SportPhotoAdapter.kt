package com.mikhailovalx.test_task_abc_team.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mikhailovalx.test_task_abc_team.R
import com.mikhailovalx.test_task_abc_team.data.Player
import com.squareup.picasso.Picasso

class SportPhotoAdapter(val photos: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<SportPhotoAdapter.SportPhotoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportPhotoViewHolder {
        return SportPhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sport_photo_item, parent, false)
        )
    }

    inner class SportPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: String) {
            Picasso.get()
                .load(photo)
                .into(itemView.findViewById<ImageView>(R.id.img_sport_photo))
        }
    }

    override fun onBindViewHolder(holder: SportPhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size
}