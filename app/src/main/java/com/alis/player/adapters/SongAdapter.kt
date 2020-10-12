package com.alis.player.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alis.player.R
import com.alis.player.extension.loadImage
import com.alis.player.models.Song
import kotlinx.android.synthetic.main.item_songs.view.*

class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private val list = mutableListOf<Song>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_songs, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun addAll(list: MutableList<Song>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(song: Song) {
            itemView.image_songs.loadImage(song.coverImage, R.drawable.default_image_album)
            itemView.text_songs_name.text = song.song
            itemView.text_songs_artist.text = song.artists
            Log.d("anime", song.song.toString())
        }
    }
}