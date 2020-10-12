package com.alis.player.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alis.player.models.Song
import com.alis.player.repository.SongRepository

class MainViewModel(private val songRepository: SongRepository) : ViewModel() {

    var song: MutableLiveData<MutableList<Song>> = MutableLiveData()

    init {
        fetchSong()
    }

    private fun fetchSong() {
        song = songRepository.fetchSong()
    }
}