package com.alis.player.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alis.player.R
import com.alis.player.adapters.SongAdapter
import com.alis.player.models.Song
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var songAdapter: SongAdapter
    private var songList: MutableList<Song> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSongRecycler()
        fetchCover()
        //subscribeToCover()
    }

    private fun createSongRecycler() {
        songAdapter = SongAdapter(songList)
        recycler_main.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = songAdapter
        }
    }

    private fun fetchCover() {
        viewModel.fetchSong().observe(this, {
            songAdapter.addAll(it)
        })
    }

    private fun subscribeToCover() {
        viewModel.cover.observe(this,
            {
                songAdapter.addAll(it)
            })
    }
}