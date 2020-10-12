package com.alis.player.ui.songs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alis.player.R
import com.alis.player.adapters.SongAdapter
import com.alis.player.models.Song
import com.alis.player.ui.player.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SongActivity : AppCompatActivity() {

    private val viewModel by viewModel<SongViewModel>()

    private lateinit var songAdapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSongRecycler()
        fetchCover()
        setUpListeners()
    }

    private fun createSongRecycler() {
        songAdapter = SongAdapter()
        recycler_main.apply {
            layoutManager = LinearLayoutManager(this@SongActivity)
            adapter = songAdapter
        }
    }

    private fun setUpListeners() {
        songAdapter.setOnItemClickListener(object : SongAdapter.OnItemClickListener {

            override fun onItemClick(item: Song) {
                PlayerActivity.start(this@SongActivity, item)
            }
        })
    }

    private fun fetchCover() {
        viewModel.song.observe(this, Observer {
            songAdapter.addAll(it)
        })
    }
}