package com.alis.player.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alis.player.R
import com.alis.player.extension.loadRoundImage
import com.alis.player.models.Song
import kotlinx.android.synthetic.main.item_songs.view.*

class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private val list = mutableListOf<Song>()
    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_songs, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    fun addAll(list: MutableList<Song>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(song: Song) {
            itemView.image_songs.loadRoundImage(
                song.coverImage,
                R.drawable.default_image_album,
                20
            )
            itemView.text_songs_name.text = song.song
            itemView.text_songs_artist.text = song.artist
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Song)
    }
}